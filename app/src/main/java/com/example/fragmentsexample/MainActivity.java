package com.example.fragmentsexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * ~ O que são fragments?
 * Fragments representam uma porção de tela, modularizando sua tela em pequenas partes. Um Fragment deve sempre
 * ser incorporado a uma Activity e seu lifecycle é diretamente afetada pela Activity que o hospeda.
 *
 *
 * ~ Vantagens
 * + Reutilização:
 *
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @OnClick(R.id.one)
    public void onClick(View view) {
        startActivity(new Intent(this, OptionOneActivity.class));
    }

}
