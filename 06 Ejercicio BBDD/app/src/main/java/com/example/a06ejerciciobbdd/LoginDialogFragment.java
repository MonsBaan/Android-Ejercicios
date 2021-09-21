package com.example.a06ejerciciobbdd;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.a06ejerciciobbdd.bbdd.AppDatabase;
import com.example.a06ejerciciobbdd.bbdd.AppExecutors;
import com.example.a06ejerciciobbdd.model.Personaje;


public class LoginDialogFragment extends DialogFragment {
    private EditText etNombre, etUrl = null;
    private Button btnConfirmar, btnCancelar = null;
    private AppDatabase mDb = null;

    public LoginDialogFragment() {
        super();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setTitle("Añadir Personaje");
        return dialog;
    }

    @Override
    public void onCancel(@NonNull DialogInterface dialog) {
        super.onCancel(dialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.dialog_personalizado, container, false);
        etNombre = vista.findViewById(R.id.etNombre);
        etUrl = vista.findViewById(R.id.etUrl);
        btnConfirmar = vista.findViewById(R.id.btnConfirmar);
        btnCancelar = vista.findViewById(R.id.btnCancelar);

        return vista;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDb = AppDatabase.getInstance(getContext());

                String nombre = etNombre.getText().toString();
                String url = etUrl.getText().toString();

                AppExecutors.getInstance().getDiskIP().execute(new Runnable() {
                    @Override
                    public void run() {
                        Personaje personaje = new Personaje(nombre, url);

                        mDb.personajeDao().insertPersonaje(personaje);
                        dismiss();
                    }
                });
            }
        });
    }
}