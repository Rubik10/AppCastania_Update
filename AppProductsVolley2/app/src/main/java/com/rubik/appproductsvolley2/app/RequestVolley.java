package com.rubik.appproductsvolley2.app;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rubik.appproductsvolley2.app.Utils.UtilsApp;
import com.rubik.appproductsvolley2.app.main.fragments.History_Fragment;
import com.rubik.appproductsvolley2.app.main.fragments.HomeFragment;
import com.rubik.appproductsvolley2.app.volley.AppConfig_Server;
import com.rubik.appproductsvolley2.app.volley.AppController;
import com.rubik.appproductsvolley2.model.CategorySection;
import com.rubik.appproductsvolley2.model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by Rubik on 3/8/16.
 */
public class RequestVolley {

    private static final String TAG = RequestVolley.class.getSimpleName();
    private Context context;

        // vars for insert history in db
    private static String KEY_IMAGE = "image";
    private static String KEY_TITLE = "tittle";
    private static String KEY_UNITS = "units";
    private static String KEY_PVP = "pvp";
    private static String KEY_RATING = "rating";


    static ProgressDialog pDialog;


    public RequestVolley (Context context) {
        this.context = context;
    }

        //Load the data by jsonObject from server
    public void JSONRequest() {

        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Loading...");
        pDialog.show();

        // Crear nueva cola de peticiones
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        // Nueva petición JSONObject
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                AppConfig_Server.URL_BASE + AppConfig_Server.URL_JSON,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        VolleyLog.d(TAG, response.toString());
                        Log.d(TAG, "JSON Load -> Games,Books,Music, Films & TVShows load");

                        HomeFragment.lisGames = parseJsonObject(response, "Games");
                        HomeFragment.lisBooks = parseJsonObject(response, "Books");
                        HomeFragment.lisMusic = parseJsonObject(response, "Music");
                        HomeFragment.lisFilms = parseJsonObject(response, "Films");

                        HomeFragment.listProductBySection.add(new CategorySection("Books" , HomeFragment.lisBooks));
                        HomeFragment.listProductBySection.add(new CategorySection("VideoGames" , HomeFragment.lisGames));
                        HomeFragment.listProductBySection.add(new CategorySection("Music" , HomeFragment.lisMusic));
                        HomeFragment.listProductBySection.add(new CategorySection("Films" , HomeFragment.lisFilms));


                     //  lisFilms = parseJsonObject(response, "Films");
                     //  listTV = parseJsonObject(response, "TV Shows");
                        pDialog.hide();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, " Error  loading JSON " +  error.getMessage());
                        VolleyLog.d(TAG, "Error Respuesta en JSON: " + error.getMessage());
                        pDialog.hide();
                    }
                }
        );

        // Añadir petición a la cola
        requestQueue.add(jsonObjectRequest);
    }

        //Load historical data by jsonArray from db
    public void JSONArrayRequest(Context context) {

        // Crear nueva cola de peticiones
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        // Nueva petición JSONObject
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(
                AppConfig_Server.URL_BASE + AppConfig_Server.URL_GET_HISTORY,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        VolleyLog.d(TAG, response.toString());
                        Log.d(TAG, "Historical JSON load" + response.toString());
                        History_Fragment.listSelected = parseJsonArray(response);
                        History_Fragment.myAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error Respuesta en JSON: " + error.getMessage());
                        Log.d(TAG, "Error al cargar el JSOn Historico" + error.getMessage());
                    }
                }
        );

        // Añadir petición a la cola
        requestQueue.add(jsonObjectRequest);
    }

    public List<Product> parseJsonObject (JSONObject jsonObject, String itemRoot){
        // Variables locales
        List<Product> listProducts = new ArrayList<>();
        JSONArray jsonArray = null;

        try {
            // Obtener el array del objeto
        jsonArray = jsonObject.getJSONArray(itemRoot);

            for(int i=0; i<jsonArray.length(); i++){

                try {
                    JSONObject objeto= jsonArray.getJSONObject(i);

                    Product products = new Product(
                            objeto.getString("titulo"),
                            objeto.getString("imagen"),
                            objeto.getInt("uds") ,
                            objeto.getDouble("precio") ,
                            objeto.getString("descripcion") ,
                            objeto.getDouble("rating")
                    );

                    listProducts.add(products);

                } catch (JSONException e) {
                    Log.e(TAG, "Error de parsing: "+ e.getMessage());
                }
            }

            Log.d(TAG, itemRoot + " parsed from JSOn");

        } catch (JSONException e) {e.printStackTrace();}

        return listProducts;
    }

    public static List<Product> parseJsonArray (JSONArray jsonArray){
        List<Product> listProducts = new ArrayList<>();

        for(int i=0; i<jsonArray.length(); i++){

            try {
                JSONObject objeto= jsonArray.getJSONObject(i);

                Product products = new Product(
                        objeto.getString("tittle"),
                        objeto.getString("imgUrl"),
                        objeto.getInt("uds") ,
                        objeto.getDouble("precio") ,
                        objeto.getDouble("rating") ,
                        Timestamp.valueOf(objeto.getString("fecha"))
                );
              //  objeto.getString("descripcion") ,

                listProducts.add(products);

            } catch (JSONException e) {
                Log.e(TAG, "Error de parsing: "+ e.getMessage());
            }
        }

        return listProducts;
    }

        // Ver xk no funciona el loader y ver error.
    public static void loadJSONImage(final ImageView imgView , String imageURl) {
        ImageLoader imageLoader = AppController.getInstance().getImageLoader();

        imageLoader.get(AppConfig_Server.URL_BASE + imageURl, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                if (null != response.getBitmap()) {
                    imgView.setImageBitmap(response.getBitmap());
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e(TAG, "Error al cargar la imagen: " + error.getMessage());
            }
        });
        // TODO: Probar - Load placeholder image and error image
       /* imageLoader.get(URL_BASE + imageURl, ImageLoader.getImageListener(
                imgView, R.drawable.ico_loading, R.drawable.ico_error)); */
    }
        // Inserta nuevo registro en la base de datos mediante php
    public static void putNewValueHistoryDB(final Context context, final View view, final Product product){

        //Showing the progress dialog
        // final ProgressDialog loading = ProgressDialog.show(context,"Uploading...","Please wait...",false,false);
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                AppConfig_Server.URL_BASE + AppConfig_Server.URL_PUT_HISTORY,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        UtilsApp.showSnackBar(view,"New historical record inserted");
                        Log.d(TAG , "New historical record inserted");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        VolleyLog.d(TAG, "Error Respuesta en JSON: " + volleyError.getMessage());
                       // Log.e("Volley error -> ", volleyError.getMessage());
                    }
                }){

            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                    //Product Parameters
                String image = product.getImageURL();//getStringImage(bitmap);
                String name = product.getTittle().trim();
                String uds = String.valueOf(product.getUnits());
                String pvp = String.valueOf(product.getPvp());
                String rating = String.valueOf(product.getRating());
                    //Creating parameters
                Map<String,String> params = new Hashtable<String,String>();
                     //Adding parameters
                params.put(KEY_IMAGE, image);
                params.put(KEY_TITLE, name);
                params.put(KEY_UNITS, uds);
                params.put(KEY_PVP, pvp);
                params.put(KEY_RATING, rating);
                    //returning parameters
                return params;
            }
        };

        //Creating a Request Queue
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        //Adding request to the queue
        requestQueue.add(stringRequest);
    }



}
