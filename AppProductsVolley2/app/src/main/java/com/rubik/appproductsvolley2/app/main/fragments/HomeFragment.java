package com.rubik.appproductsvolley2.app.main.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.rubik.appproductsvolley2.R;
import com.rubik.appproductsvolley2.app.RequestVolley;
import com.rubik.appproductsvolley2.app.main.adapters.home.MyRecyclerHomeVerticalAdapter;
import com.rubik.appproductsvolley2.model.CategorySection;
import com.rubik.appproductsvolley2.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private static final String TAG = HomeFragment.class.getSimpleName();
    public static List<CategorySection> listProductBySection;
    public static MyRecyclerHomeVerticalAdapter myVertcalAdapter;

    public static List<Product> lisGames = new ArrayList<>();
    public static List<Product> lisBooks = new ArrayList<>();
    public static List<Product> lisFilms = new ArrayList<>();
    public static List<Product> listTV = new ArrayList<>();
    public static List<Product> lisMusic = new ArrayList<>();

    public HomeFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view_Games);

          /*  listProductBySection = new ArrayList<CategorySection>();
            RequestVolley requestVolley = new RequestVolley(getContext());
            requestVolley.JSONRequest();*/

            initVerticalRecyclerView(recyclerView);

        return viewGroup;
    }

    public void initHomeSection () {
        listProductBySection = new ArrayList<CategorySection>();
        RequestVolley requestVolley = new RequestVolley(getContext());
        requestVolley.JSONRequest();
    }

    private void initVerticalRecyclerView(final RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 1, GridLayout.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        myVertcalAdapter = new MyRecyclerHomeVerticalAdapter(getContext(),listProductBySection); //, listProducts
        recyclerView.setAdapter(myVertcalAdapter);

    }


}
