package com.example.fragmentsexample;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by philipesteiff on 10/9/15.
 */
public class DummyFragment extends Fragment {

    public static final String TAG = "DummyFragment";
    public static final String ARG_TITLE = "ARG_TITLE";

    @Bind(R.id.text_test)
    TextView textViewTest;

    @Bind(R.id.edit_test)
    EditText editTextTest;

    // - Padrão comum para inicializar fragments com argumentos
    public static DummyFragment newInstance(final String title) {
        DummyFragment fragment = new DummyFragment();
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

    // - É chamado para o fragment criar sua propria view.
    // - Retornando null o fragment passa a não ter view.
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dummy_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    // - Normalmente utilizado para setar valores e listeners as views.
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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

}
