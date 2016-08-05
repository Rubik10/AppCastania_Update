package com.rubik.appproductsvolley2.app.main.adapters.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.rubik.appproductsvolley2.R;
import com.rubik.appproductsvolley2.app.RequestVolley;
import com.rubik.appproductsvolley2.app.Utils.UtilsApp;
import com.rubik.appproductsvolley2.app.volley.AppConfig_Server;
import com.rubik.appproductsvolley2.model.Product;

import java.util.List;

/**
 * Created by Rubik on 4/8/16.
 */
public class MyRecyclerHomeHorizontalAdapter extends RecyclerView.Adapter<MyRecyclerHomeHorizontalAdapter.HorizontalRowHolder> {

    private List<Product> listProduct;
    private Context context;

    public MyRecyclerHomeHorizontalAdapter(Context context, List<Product> listProduct) {
        this.listProduct = listProduct;
        this.context = context;
    }

    @Override
    public HorizontalRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardlayout_home, null);
        HorizontalRowHolder horizontalRowHolder = new HorizontalRowHolder(view);
        return horizontalRowHolder;
    }

    @Override
    public void onBindViewHolder(final HorizontalRowHolder holder, final int pos) {

        final Product product = listProduct.get(pos);
        final String tittle = product.getTittle();
        final String url = product.getImageURL();

        holder.txtProductTittle.setText(tittle);

      //  RequestVolley.loadJSONImage(holder.itemImage, product.getImageURL());
        Glide.with(context)
                .load(AppConfig_Server.URL_BASE + product.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(holder.itemImage);
               // .error(R.drawable.lastofus)

        holder.itemImage .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UtilsApp.showSnackBar(view, holder.txtProductTittle.getText().toString());
                    // Insert into db new historic registry
                RequestVolley.putNewValueHistoryDB(context, view ,product);
                    // Open the detail activity
                UtilsApp.runIntentDetail(context, listProduct, pos);
            }
        });

    }

    @Override
    public int getItemCount() {return (null != listProduct ? listProduct.size() : 0);}


    public class HorizontalRowHolder extends RecyclerView.ViewHolder {

        protected TextView txtProductTittle;
        protected ImageView itemImage;


        public HorizontalRowHolder(final View view) {
            super(view);

            this.txtProductTittle = (TextView) view.findViewById(R.id.txtTituloHome);
            this.itemImage = (ImageView) view.findViewById(R.id.imgHome);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }

            });



         }
    }


}
