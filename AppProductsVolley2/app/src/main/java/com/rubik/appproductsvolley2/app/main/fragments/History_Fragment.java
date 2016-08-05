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
import com.rubik.appproductsvolley2.app.main.adapters.MyRecycleHistorycAdapter;
import com.rubik.appproductsvolley2.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 *
 * Implemntel el swipeRefreshLayout
 */
public class History_Fragment extends Fragment {

    public static MyRecycleHistorycAdapter myAdapter;
    public static List<Product> listSelected=new ArrayList<Product>();


    public History_Fragment() {// Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_history, container, false);
        RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view_history);

        if (savedInstanceState == null) {
            /*RequestVolley requestVolley = new RequestVolley(getContext());
            requestVolley.JSONArrayRequest(getContext());*/
            iniRecycleView(recyclerView);
        }

        return viewGroup;
    }

    private void iniRecycleView(RecyclerView recyclerView) {

        myAdapter = new MyRecycleHistorycAdapter(); //, getActivity()
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 1, GridLayout.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);

    }

}
