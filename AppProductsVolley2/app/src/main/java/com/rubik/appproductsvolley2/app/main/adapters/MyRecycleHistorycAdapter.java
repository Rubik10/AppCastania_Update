package com.rubik.appproductsvolley2.app.main.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rubik.appproductsvolley2.R;
import com.rubik.appproductsvolley2.app.main.fragments.History_Fragment;
import com.rubik.appproductsvolley2.app.volley.AppConfig_Server;
import com.rubik.appproductsvolley2.model.Product;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Rubik on 29/7/16.
 *
 * TODO: MIRAR ERROR EN EL DISEÑO DEL XML (cardlayout_history2) AL HACER SCROLL.
 */
public class MyRecycleHistorycAdapter extends RecyclerView.Adapter<MyRecycleHistorycAdapter.MyViewHolder>{

    private static final String TAG = MyRecycleHistorycAdapter.class.getSimpleName();

    public MyRecycleHistorycAdapter() {}

    @Override
    public MyRecycleHistorycAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout_history2, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyRecycleHistorycAdapter.MyViewHolder holder, int position) {

        final Product product = History_Fragment.listSelected.get(position);

        holder.txtTittle.setText(product.getTittle());
        holder.txtUnits.setText(String.valueOf(product.getUnits() + " uds."));
       // holder.txtDescription.setText(product.getDescription());
        holder.txtRating.setText(String.valueOf(product.getRating()));

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.ITALY); // xk coño no esta ESPAÑAAAA?¿?¿?¿
        String pvpFormatter = format.format(product.getPvp());
        holder.txtPVP.setText(pvpFormatter);

        CharSequence fecha = (DateFormat.format("dd-MM-yyyy HH:mm", product.getFecha()));
        holder.txtFecha.setText(fecha);

        Glide.with(holder.itemView.getContext())
                .load(AppConfig_Server.URL_BASE + product.getImageURL())
                .into(holder.imageView);
       // RequestVolley.loadJSONImage(holder.imageView, product.getImageURL());

        holder.ratingBar.setRating(product.getRating().floatValue());
    }

    @Override
    public int getItemCount() {return History_Fragment.listSelected != null ? History_Fragment.listSelected.size() : 0;}


         public class MyViewHolder extends RecyclerView.ViewHolder {
            private ImageView imageView;
            private TextView txtTittle;
            private TextView txtFecha;
            private TextView txtUnits;
            private TextView txtPVP;
            private TextView txtDescription;
            private TextView txtRating;
             private RatingBar ratingBar;

            LinearLayout borderLayout;

            public MyViewHolder(View view) {
                super(view);

                imageView = (ImageView) view.findViewById(R.id.imageHistory2);
                txtTittle = (TextView) view.findViewById(R.id.txtTittleHistory2);
                txtFecha = (TextView) view.findViewById(R.id.txtFechaHistory2);
                txtUnits = (TextView) view.findViewById(R.id.txtUnitsHistory2);
                txtPVP = (TextView) view.findViewById(R.id.txtPvp2);
                txtDescription = (TextView) view.findViewById(R.id.txtDescriptionHistory2);
                txtRating = (TextView) view.findViewById(R.id.lblRatingHistory);
                ratingBar = (RatingBar) view.findViewById(R.id.ratingBarHistory);


               // txtFecha.setVisibility(View.VISIBLE);
                // borderLayout = (LinearLayout) view.findViewById(R.id.linearLayoutBoder);
            }


    }
}
