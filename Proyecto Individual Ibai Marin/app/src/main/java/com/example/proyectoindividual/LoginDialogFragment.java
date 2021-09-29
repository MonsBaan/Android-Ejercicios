package com.example.proyectoindividual;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectoindividual.bbdd.AppDatabase;
import com.example.proyectoindividual.bbddUser.AppDatabaseUser;
import com.example.proyectoindividual.bbddUser.AppExecutorsUser;
import com.example.proyectoindividual.bbddUser.model.Usuario;

import java.util.zip.Inflater;


public class LoginDialogFragment extends DialogFragment {
    private EditText etUser, etPass;
    private Button btnAcceder, btnCancelar;
    private Context context;
    private AppDatabaseUser mDb;


    public LoginDialogFragment() {
        super();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_login_dialog, container, false);
        return vista;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etUser = view.findViewById(R.id.etUser);
        etPass = view.findViewById(R.id.etPass);
        btnAcceder = view.findViewById(R.id.btnAccederLogin);
        btnCancelar = view.findViewById(R.id.btnCancelarLogin);

        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = etUser.getText().toString();
                String pass = etPass.getText().toString();

                mDb = AppDatabaseUser.getInstance(context);
                AppExecutorsUser.getInstance().getDiskIP().execute(new Runnable() {
                    @Override
                    public void run() {
                        Usuario userDB = mDb.UsuarioDao().loginUsuario(user, pass);

                        Intent intent = new Intent(context, LoginExamenActivity.class);
                        startActivity(intent);

                        /*if (userDB == null) {
                            Looper.prepare();
                            Toast.makeText(context, "No hay ese user", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.d("ibai", "Existe el user");

                        }*/


                    }
                });

            }
        });

        btnAcceder.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mDb = AppDatabaseUser.getInstance(context);
                String user = etUser.getText().toString();
                String pass = etPass.getText().toString();

                AppExecutorsUser.getInstance().getDiskIP().execute(new Runnable() {
                    @Override
                    public void run() {
                        mDb.UsuarioDao().insertUser(new Usuario(user, pass));
                        Log.d("ibai", "Usuario '" + user + "' Contraseña '" + pass + "'");
                    }
                });
                return false;
            }
        });


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
    }
}