package com.rubik.appproductsvolley2.app.main.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rubik.appproductsvolley2.R;
import com.rubik.appproductsvolley2.app.RequestVolley;
import com.rubik.appproductsvolley2.app.Utils.UtilsApp;
import com.rubik.appproductsvolley2.app.volley.AppConfig_Server;
import com.rubik.appproductsvolley2.model.Product;

import java.util.List;

/**
 * Created by Rubik on 4/8/16.
 */
public class MyRecycleCategoryAdapter  extends RecyclerView.Adapter<MyRecycleCategoryAdapter.ViewHolder> {

    private static final String TAG = MyRecycleCategoryAdapter.class.getSimpleName();
    private final List<Product> listItems;
    private Context context;

    public MyRecycleCategoryAdapter(Context context,List<Product> itemsProducts) {
        this.context=context;
        this.listItems = itemsProducts;
    }

        @Override
        public int getItemCount() {  return (null != listItems ? listItems.size() : 0);  }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemlist_categories, viewGroup, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder,final int pos) {
            final Product product = listItems.get(pos);

            holder.nombre.setText(product.getTittle());
            holder.rating.setRating(product.getRating().floatValue());
            holder.lblRating.setText(product.getRating().toString());

            Glide.with(holder.itemView.getContext())
                    .load(AppConfig_Server.URL_BASE + product.getImageURL())
                    .fitCenter()
                    .into(holder.imagen);

            holder.imagen .setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UtilsApp.showSnackBar(view, holder.nombre.getText().toString());
                        // Insert into db new historic registry
                    RequestVolley.putNewValueHistoryDB(context, view,product);
                        // Open the detail activity
                    UtilsApp.runIntentDetail(context, listItems, pos);
                }
            });
        }




    public class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
        public RatingBar rating;
        public ImageView imagen;
        public TextView lblRating;

        public ViewHolder(View view) {
            super(view);

            nombre = (TextView) view.findViewById(R.id.txtCatTitulo);
            imagen = (ImageView) view.findViewById(R.id.imgCat);
            rating = (RatingBar) view.findViewById(R.id.ratingBar);
            lblRating = (TextView) view.findViewById(R.id.lblRating);
        }
    }

}
