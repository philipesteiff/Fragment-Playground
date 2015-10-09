package com.example.fragmentsexample;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by philipesteiff on 10/9/15.
 */

/**
 * Fragments Estaticos.
 */
public class OptionOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_one);
        if (savedInstanceState == null) {

            // Ativa o log de transações do fragmentManager
            FragmentManager.enableDebugLogging(true);

            // Adicionando fragment ao container
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.frame_option_one_fragment_container, new TestFragment(), TestFragment.TAG);
            fragmentTransaction.commit();
        }

    }
}
