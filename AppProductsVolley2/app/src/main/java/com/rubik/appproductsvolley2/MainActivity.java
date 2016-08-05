package com.rubik.appproductsvolley2;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.rubik.appproductsvolley2.app.RequestVolley;
import com.rubik.appproductsvolley2.app.main.fragments.CategoryFragment;
import com.rubik.appproductsvolley2.app.main.fragments.History_Fragment;
import com.rubik.appproductsvolley2.app.main.fragments.HomeFragment;
import com.rubik.appproductsvolley2.model.CategorySection;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        initNavigationView();

        initVolleyRequest();
    }

    public void initVolleyRequest () {
        HomeFragment. listProductBySection = new ArrayList<CategorySection>();
        RequestVolley requestVolley = new RequestVolley(this);
        requestVolley.JSONRequest();
    }


    private void initToolbar () {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Poner ícono del drawer toggle
            actionBar.setHomeAsUpIndicator(R.drawable.drawer_toggle);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initNavigationView() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            preppareDrawer(navigationView);
                 // Select the default item
            setSelectedItem(navigationView.getMenu().getItem(0));
        }
    }

    private void preppareDrawer(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener( new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                setSelectedItem(menuItem);
                drawerLayout.closeDrawers();
                return true;
            }
        });

    }

    public  void setSelectedItem(MenuItem itemDrawer) {
        android.support.v4.app.Fragment fragment = null;
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (itemDrawer.getItemId()) {
            case R.id.item_inicio:
                Log.d(TAG, " Open Home fragment");
                fragment = new HomeFragment();
                break;
            case R.id.item_categorias:
                Log.d(TAG, " Open Category fragment");
                fragment = new CategoryFragment();
                break;
            case R.id.item_historic:
                RequestVolley requestVolley = new RequestVolley(this);
                requestVolley.JSONArrayRequest(this);

                Log.d(TAG, " Open History fragment");
                fragment = new History_Fragment();
                break;
            case R.id.item_configuracion:
                break;
        }
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.mainContent, fragment)
                    .commit();
        }

        // Setear título actual
        setTitle(itemDrawer.getTitle());
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_navdrawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
