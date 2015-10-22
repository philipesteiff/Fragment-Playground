package com.example.fragmentsexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * ~ O que são fragments?
 * Fragments representam uma porção de tela, modularizando sua tela em pequenas partes. Um Fragment deve sempre
 * ser incorporado a uma Activity e seu lifecycle é diretamente afetada pela Activity que o hospeda.
 * <p/>
 * <p/>
 * ~ Vantagens
 * + Reutilização:
 */

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Ativa o log de transações do fragmentManager
        FragmentManager.enableDebugLogging(true);
    }

    @OnClick(R.id.attach)
    public void onAttachClick(View view) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.viewgroup_fragment_container);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.attach(fragment);
        fragmentTransaction.commit();
    }


    @OnClick(R.id.add)
    public void onAddClick(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.viewgroup_fragment_container, new DummyFragment(), DummyFragment.TAG);
        fragmentTransaction.commit();
    }


    @OnClick(R.id.remove)
    public void onRemoveClick(View view) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.viewgroup_fragment_container);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }


    @OnClick(R.id.detach)
    public void onDetachClick(View view) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.viewgroup_fragment_container);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.detach(fragment);
        fragmentTransaction.commit();
    }

    @OnClick(R.id.pop_back_stack)
    public void onPopBackStackClick(View view) {
        getSupportFragmentManager().popBackStack();
    }

    @OnClick(R.id.debug)
    public void onDebugClick() {

    }



}
