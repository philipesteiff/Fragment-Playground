package com.example.fragmentsexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import butterknife.Bind;
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

public class FragmentPlaygroundActivity extends AppCompatActivity {

    private boolean enableAddToBackStack;
    private boolean enableRetainInstance;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.toogle_button_back_stack)
    ToggleButton toggleButtonBackStack;

    @Bind(R.id.toogle_button_retain_instance)
    ToggleButton toggleButtonRetainInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toggleButtonBackStack.setOnCheckedChangeListener(onAddToBackStackCheckedChangeListener);
        toggleButtonRetainInstance.setOnCheckedChangeListener(onRetainInstanceCheckedChangeListener);

        // Ativa o log de transações do fragmentManager
        FragmentManager.enableDebugLogging(true);
    }

    @OnClick(R.id.add)
    public void onAddClick(View view) {
        Fragment fragment = DummyFragment.newInstance("Meu Fragment");
        if (enableRetainInstance)
            fragment.setRetainInstance(true);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.viewgroup_fragment_container, fragment, DummyFragment.TAG);
        if (enableAddToBackStack)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @OnClick(R.id.attach)
    public void onAttachClick(View view) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(DummyFragment.TAG);
        if (enableRetainInstance)
            fragment.setRetainInstance(true);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.attach(fragment);
        if (enableAddToBackStack)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @OnClick(R.id.remove)
    public void onRemoveClick(View view) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(DummyFragment.TAG);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragment);
        if (enableAddToBackStack)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    @OnClick(R.id.detach)
    public void onDetachClick(View view) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.viewgroup_fragment_container);
        if (enableRetainInstance)
            fragment.setRetainInstance(true);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.detach(fragment);
        if (enableAddToBackStack)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @OnClick(R.id.replace)
    public void onReplaceClick(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.viewgroup_fragment_container, DummyFragment.newInstance("Novo Fragment"), DummyFragment.TAG);
        if (enableAddToBackStack)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @OnClick(R.id.pop_back_stack)
    public void onPopBackStackClick(View view) {
        getSupportFragmentManager().popBackStack();
    }

    @OnClick(R.id.debug)
    public void onDebugClick() {

    }

    CompoundButton.OnCheckedChangeListener onAddToBackStackCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            enableAddToBackStack = isChecked;
        }
    };

    CompoundButton.OnCheckedChangeListener onRetainInstanceCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            enableRetainInstance = isChecked;
        }
    };

}
