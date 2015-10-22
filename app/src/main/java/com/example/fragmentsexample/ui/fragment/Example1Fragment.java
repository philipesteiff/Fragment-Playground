package com.example.fragmentsexample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.example.fragmentsexample.R;

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
 * + Stack
 * +
 */

public class Example1Fragment extends BaseFragment {

    private boolean enableAddToBackStack;
    private boolean enableRetainInstance;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.toogle_button_back_stack)
    ToggleButton toggleButtonBackStack;

    @Bind(R.id.toogle_button_retain_instance)
    ToggleButton toggleButtonRetainInstance;


    public static Example1Fragment newInstance() {
        return new Example1Fragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, getView());
        toggleButtonBackStack.setOnCheckedChangeListener(onAddToBackStackCheckedChangeListener);
        toggleButtonRetainInstance.setOnCheckedChangeListener(onRetainInstanceCheckedChangeListener);

        // Ativa o log de transações do fragmentManager
        FragmentManager.enableDebugLogging(true);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_example_1;
    }

    @Override
    public String tag() {
        return Example1Fragment.class.getSimpleName();
    }


    @SuppressWarnings("unused")
    @OnClick(R.id.add)
    public void onAddClick(View view) {
        Fragment fragment = Example2Fragment.newInstance("Meu Fragment");
        if (enableRetainInstance)
            fragment.setRetainInstance(true);

        FragmentTransaction fragmentTransaction =getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.viewgroup_fragment_container, fragment, Example2Fragment.TAG);
        if (enableAddToBackStack)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.attach)
    public void onAttachClick(View view) {
        Fragment fragment = getFragmentManager().findFragmentByTag(Example2Fragment.TAG);
        if (enableRetainInstance)
            fragment.setRetainInstance(true);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.attach(fragment);
        if (enableAddToBackStack)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.remove)
    public void onRemoveClick(View view) {
        Fragment fragment = getFragmentManager().findFragmentByTag(Example2Fragment.TAG);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragment);
        if (enableAddToBackStack)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.detach)
    public void onDetachClick(View view) {
        Fragment fragment = getFragmentManager().findFragmentById(R.id.viewgroup_fragment_container);
        if (enableRetainInstance)
            fragment.setRetainInstance(true);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.detach(fragment);
        if (enableAddToBackStack)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.replace)
    public void onReplaceClick(View view) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.viewgroup_fragment_container, Example2Fragment.newInstance("Novo Fragment"), Example2Fragment.TAG);
        if (enableAddToBackStack)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.pop_back_stack)
    public void onPopBackStackClick(View view) {
        getFragmentManager().popBackStack();
    }

    @SuppressWarnings("unused")
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
