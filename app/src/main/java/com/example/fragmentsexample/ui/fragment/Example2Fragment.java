package com.example.fragmentsexample.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fragmentsexample.R;

import java.util.UUID;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by philipesteiff on 10/9/15.
 */
public class Example2Fragment extends BaseFragment {

    public static final String TAG = "Example2Fragment";
    public static final String ARG_TITLE = "ARG_TITLE";

    @Bind(R.id.text_test)
    TextView textViewTest;

    @Bind(R.id.edit_test)
    EditText editTextTest;

    // - Padrão comum para inicializar fragments com argumentos
    public static Example2Fragment newInstance(final String title) {
        Example2Fragment fragment = new Example2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    // - Primeiro metodo chamado, antes da criacao de qualquer view.
    // - Chamado quando a instancia do fragment é associado a activity.
    // - Não é garantido que a activity foi completamente inicializada.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    // - Segundo método chamado, antes das views do fragment serem criadas.
    // - O onCreate é chamado quando a instancia do Fragment é criada ou recriada.
    // - O método onCreate é chamado quando a instância do Fragment está sendo criado, ou recriado.
    // - Não é garantido que a activity foi completamente inicializada.
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    // - Normalmente utilizado para setar valores e listeners as views.
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        textViewTest.setText(getArguments().getString(ARG_TITLE));
    }

    // - Chamado depois que a activity host completar o onCreate().
    // - Qualquer acesso a hieraquia de view da activity host deve ser feita aqui.
    // - Nesse ponto é seguro interagir com a activity.
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @OnClick(R.id.button_change_test)
    public void OnChangeTextClick(View view) {
        editTextTest.setText(UUID.randomUUID().toString());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_example_2;
    }

    @Override
    public String tag() {
        return Example2Fragment.class.getSimpleName();
    }


}
