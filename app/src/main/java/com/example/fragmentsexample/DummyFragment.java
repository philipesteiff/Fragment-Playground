package com.example.fragmentsexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by philipesteiff on 10/9/15.
 */
public class DummyFragment extends Fragment {

    public static final String TAG = "DummyFragment";




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dummy_fragment, container, false);
    }
}
