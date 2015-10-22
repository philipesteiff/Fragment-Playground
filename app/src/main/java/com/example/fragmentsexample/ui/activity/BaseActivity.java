package com.example.fragmentsexample.ui.activity;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.fragmentsexample.R;

/**
 * Created by msanches on 22/10/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }


    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (getParentActivityName() != null) {
                navigateUp(getParentActivityName());
            } else {
                navigateBack();
            }
            return true;
        }
        return false;
    }


    private void init() {
        setContentView(getLayoutResource());
        //dataBinding = DataBindingUtil.setContentView(this, getLayoutResource());
        initToolbar();
    }

    public void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowTitleEnabled(true);
                setSupportActionBar(toolbar);
            }
        }
    }


    String getParentActivityName() {
        return NavUtils.getParentActivityName(this);
    }

    void navigateBack() {
        onBackPressed();
    }

    void navigateUp(final String parentActivityName) {
        NavUtils.navigateUpFromSameTask(this);
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    protected abstract int getLayoutResource();
}
