package com.rubik.appproductsvolley2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.melnykov.fab.FloatingActionButton;
import com.rubik.appproductsvolley2.R;
import com.rubik.appproductsvolley2.app.Utils.UtilsApp;
import com.rubik.appproductsvolley2.app.volley.AppConfig_Server;

import java.text.NumberFormat;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent intent=getIntent();

        final String title = intent.getExtras().getString("Title");
        final Double pvp = intent.getExtras().getDouble("Precio");
        final int units = intent.getExtras().getInt("Unidades");
        final String description = intent.getExtras().getString("Descripcion");
        final String image = intent.getExtras().getString("Imagen");
        final Double rating = intent.getExtras().getDouble("Rating");

        Log.d(DetailActivity.class.getSimpleName(), image);

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.ITALY); // xk coño no esta ESPAÑAAAA?¿?¿?¿
        // format.setCurrency(Currency.getInstance("ESP"));
        String pvpFormatter = format.format(pvp);


        ImageView imageView = (ImageView) findViewById(R.id.imageViewDetail);
        TextView txtTittle = (TextView) findViewById(R.id.txtTituloDetail);
        TextView txtPvp = (TextView) findViewById(R.id.txtPvpDetail);
        TextView txtUnidades = (TextView) findViewById(R.id.textoUnitsDetail);
        TextView txtDescription = (TextView) findViewById(R.id.txtDescDetail);
        TextView txtRating = (TextView) findViewById(R.id.lblRatingDetail);
        RatingBar ratingBar = (RatingBar)  findViewById(R.id.ratingBarDetail);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        txtTittle.setText(title);
        txtPvp.setText(pvpFormatter);
        txtUnidades.setText(String.valueOf(units) + " Uds.");
        txtDescription.setText(description);
        txtRating.setText(rating.toString());
        ratingBar.setRating(rating.floatValue());

        Glide.with(this)
                .load(AppConfig_Server.URL_BASE + image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);

        //Picasso.with(this).load(AppConfig_Server.URL_BASE + image).fit().into(imageView);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilsApp.showSnackBar(v, "La edición e insercion de Productos vendrá en próximas actializaciones");
            }
        });

    }

}
