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
import com.rubik.appproductsvolley2.app.main.adapters.MyRecycleCategoryAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {

    private static final String TAG = ProductFragment.class.getSimpleName();
    private static final String INDEX_SECTION = "";
    private MyRecycleCategoryAdapter myCategoryAdapter;


    public ProductFragment() {}

    public static ProductFragment newInstance (int sectionIndex) {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putInt(INDEX_SECTION, sectionIndex);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        RecyclerView recyclerViewCat = (RecyclerView) view.findViewById(R.id.recycle_VieCat);
        recyclerViewCat.setHasFixedSize(true);
        recyclerViewCat.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayout.VERTICAL,false));
        recyclerViewCat.setItemAnimator(new DefaultItemAnimator());

        int indexSection = getArguments().getInt(INDEX_SECTION);

        switch (indexSection) {
            case 0:
                myCategoryAdapter = new MyRecycleCategoryAdapter(getActivity(),HomeFragment.lisGames);
                break;
            case 1:
                myCategoryAdapter = new MyRecycleCategoryAdapter(getContext(),HomeFragment.lisBooks);
                break;
            case 2:
                myCategoryAdapter = new MyRecycleCategoryAdapter(getActivity(),HomeFragment.lisMusic);
                break;
            case 3:
                myCategoryAdapter = new MyRecycleCategoryAdapter(getActivity(),HomeFragment.lisFilms);
                break;
        }

        recyclerViewCat.setAdapter(myCategoryAdapter);
        myCategoryAdapter.notifyDataSetChanged();


        return view;
    }

}
