package com.example.fragmentsexample.ui.activity;

import android.os.Bundle;
import com.example.fragmentsexample.R;
import com.example.fragmentsexample.ui.fragment.Example1Fragment;
import com.example.fragmentsexample.utils.FragmentUtils;

/**
 * Created by msanches on 22/10/15.
 */
public class MainActivity extends BaseNavigationDrawerActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentUtils.replaceFragment(getSupportFragmentManager(), Example1Fragment.newInstance(), Example1Fragment.TAG, R.id.frame_main_container, false);
    }
}
