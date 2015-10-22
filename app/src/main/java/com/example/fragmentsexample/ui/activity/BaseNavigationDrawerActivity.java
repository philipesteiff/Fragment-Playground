package com.example.fragmentsexample.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.fragmentsexample.R;
import com.example.fragmentsexample.ui.fragment.BaseFragment;
import com.example.fragmentsexample.ui.fragment.Example1Fragment;
import com.example.fragmentsexample.ui.fragment.Example2Fragment;
import com.example.fragmentsexample.utils.FragmentUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by msanches on 29/08/15.
 */
public class BaseNavigationDrawerActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.frame_home_container)
    FrameLayout frameHomeContainer;
    @Bind(R.id.navigation_home_view)
    NavigationView navigationHomeView;
    @Bind(R.id.drawer_home)
    DrawerLayout drawerHome;
    private ActionBarDrawerToggle drawerToggle;
    @Bind(R.id.text_profile_view_name)
    TextView textProfileViewName;
    @Bind(R.id.text_profile_view_email)
    TextView textProfileViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerHome.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void init() {
        ButterKnife.bind(this);
        initNavigationView();
        initToogle();
    }


    private void initNavigationView() {
        navigationHomeView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerHome.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.drawer_example_1:
                        changeFragment(Example1Fragment.newInstance());
                        break;
                    case R.id.drawer_example_2:
                        changeFragment(Example2Fragment.newInstance("Título"));
                        break;
                }
                return true;
            }
        });

    }

    private void initToogle() {
        drawerToggle = new ActionBarDrawerToggle(this, drawerHome, R.string.open, R.string.close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /**
             * Called when a drawer has settled in a completely open state.
             */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerHome.setDrawerListener(drawerToggle);
    }

    public void changeFragment(final BaseFragment baseFragment) {
        FragmentUtils.replaceFragment(getSupportFragmentManager(), baseFragment, R.id.frame_home_container, false);
    }


}
