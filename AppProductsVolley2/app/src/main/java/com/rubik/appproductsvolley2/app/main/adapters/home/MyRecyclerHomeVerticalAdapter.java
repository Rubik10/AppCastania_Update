package com.rubik.appproductsvolley2.app.main.adapters.home;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rubik.appproductsvolley2.R;
import com.rubik.appproductsvolley2.app.Utils.UtilsApp;
import com.rubik.appproductsvolley2.model.CategorySection;
import com.rubik.appproductsvolley2.model.Product;

import java.util.List;

/**
 * Created by Rubik on 4/8/16.
 */
public class MyRecyclerHomeVerticalAdapter extends RecyclerView.Adapter<MyRecyclerHomeVerticalAdapter.ViewHolder> {

    private List<CategorySection> listCateogySection;
    private Context context;

    public MyRecyclerHomeVerticalAdapter(Context context, List<CategorySection> dataListSection) {
        this.listCateogySection = dataListSection;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemlist_home_horiz, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() { return (null != listCateogySection ? listCateogySection.size() : 0);  }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {

        //Data
        final String sectionName = listCateogySection.get(i).getCategoryHeaderTitle();
        List<Product> listProductPerSection = listCateogySection.get(i).getAllProducInSection();
        holder.itemTitle.setText(sectionName);

        initHorizontalRecyclerView(holder, listProductPerSection, sectionName);
    }

    private void initHorizontalRecyclerView (ViewHolder holder , List<Product> list , final String sectionName) {

            // Horizontal Adapter
        MyRecyclerHomeHorizontalAdapter horizontalAdapter = new MyRecyclerHomeHorizontalAdapter(context, list);
        holder.recycler_view_list.setHasFixedSize(true);
        holder.recycler_view_list.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recycler_view_list.setAdapter(horizontalAdapter);

        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(v.getContext(), "click event on more, " + sectionName , Toast.LENGTH_SHORT).show();
                // new CategoryFragment();
                UtilsApp.showSnackBar(v, "Aquí quería mando al user a su respectiva pestaña ... ;)" + sectionName);
            }
        });

    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView itemTitle;
        protected RecyclerView recycler_view_list;
        protected ImageButton btnMore;


        public ViewHolder(View view) {
            super(view);

            this.itemTitle = (TextView) view.findViewById(R.id.itemTitle);
            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.recycler_view_list);
            this.btnMore= (ImageButton) view.findViewById(R.id.btnMore);
        }

    }
}
