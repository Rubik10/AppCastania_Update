package com.rubik.appproductsvolley2.app.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.rubik.appproductsvolley2.activity.DetailActivity;
import com.rubik.appproductsvolley2.model.Product;

import java.util.List;

/**
 * Created by Rubik on 29/7/16.
 */
public class UtilsApp {

    public static void showToast(Context cxt, String msg) {
        Toast.makeText(cxt,msg, Toast.LENGTH_LONG).show();
    };
    public static void showSnackBar(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    };

    public static void runIntentDetail(Context context, List<Product> listProducts, int pos ) {
        Intent intent = new Intent(context, DetailActivity.class);
        //Put data
        intent.putExtra("Title",listProducts.get(pos).getTittle());
        intent.putExtra("Precio",listProducts.get(pos).getPvp());
        intent.putExtra("Unidades",listProducts.get(pos).getUnits());
        intent.putExtra("Descripcion",listProducts.get(pos).getDescription());
        intent.putExtra("Imagen",listProducts.get(pos).getImageURL() );
        intent.putExtra("Rating",listProducts.get(pos).getRating() );

        context.startActivity(intent);
    }


}
