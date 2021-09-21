package com.example.a06dialogpersonalizado;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.a06dialogpersonalizado.bbdd.AppDatabase;
import com.example.a06dialogpersonalizado.bbdd.AppExecutors;
import com.example.a06dialogpersonalizado.model.Usuario;

public class LoginDialogFragment extends DialogFragment {
    private EditText etNombre, etPass = null;
    private Button btnAceptar, btnCancelar = null;
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
        dialog.setTitle("Login");
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
        etNombre = vista.findViewById(R.id.tilUser);
        etPass = vista.findViewById(R.id.tilPass);
        btnAceptar = vista.findViewById(R.id.btnAceptar);
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
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDb = AppDatabase.getInstance(getContext());

                String nombre = etNombre.getText().toString();
                String pass = etPass.getText().toString();

                AppExecutors.getInstance().getDiskIP().execute(new Runnable() {
                    @Override
                    public void run() {
                        Usuario usu = mDb.usuariosDao().loadUsuarioByNamePass(nombre, pass);
                        if (usu != null) {
                            //Toast.makeText(getContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getContext(), CentralActivity.class);
                            startActivity(intent);
                        } else {
                            //Toast.makeText(getContext(), "N O", Toast.LENGTH_SHORT).show();
                            dismiss();
                        }

                    }
                });

            }
        });
    }

}
