package com.rubik.appproductsvolley2.app.main.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rubik.appproductsvolley2.R;
import com.rubik.appproductsvolley2.app.main.adapters.ViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    private AppBarLayout appBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        if (savedInstanceState == null) {
            insertNewTabs(container);

            // Setear adaptador al viewpager.
            viewPager = (ViewPager) view.findViewById(R.id.viewPager);
            initViewPager(viewPager);
            tabLayout.setupWithViewPager(viewPager);
        }

        return view;
    }

    private void insertNewTabs(ViewGroup container) {
        View parent = (View) container.getParent();
        appBar = (AppBarLayout) parent.findViewById(R.id.appbar);
        tabLayout = new TabLayout(getActivity());
        tabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        appBar.addView(tabLayout);
    }

    private void initViewPager(ViewPager viewPager) {
        final ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(ProductFragment.newInstance(0), "VideoGames");
        adapter.addFragment(ProductFragment.newInstance(1), "Books");
        adapter.addFragment(ProductFragment.newInstance(2), "Music");
        adapter.addFragment(ProductFragment.newInstance(3), "Films");
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
               // adapter.notifyDataSetChanged();
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }





    @Override
    public void onDestroyView() {
        super.onDestroyView();
        appBar.removeView(tabLayout);
    }

}
