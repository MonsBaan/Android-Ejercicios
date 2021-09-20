package com.example.navigationdrawer.ui.verde;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navigationdrawer.R;
import com.example.navigationdrawer.UserAlmi;

import java.util.ArrayList;
import java.util.List;

public class VerdeFragment extends Fragment {

    private VerdeViewModel mViewModel;
    private EditText etNombre, etEdad = null;
    private Button btnGuardar, btnVerUser = null;
    private TextView tvVerdeSinVm, tvVerdeConVm = null;
    private List<UserAlmi> userAlmiList;

    public static VerdeFragment newInstance() {
        return new VerdeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.verde_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VerdeViewModel.class);
        // TODO: Use the ViewModel
        userAlmiList = new ArrayList<>();
        btnGuardar = getView().findViewById(R.id.btnVerdeGuardar);
        btnVerUser = getView().findViewById(R.id.btnVerdeVer);
        etNombre = getView().findViewById(R.id.etVerdeNombre);
        etEdad = getView().findViewById(R.id.etVerdeEdad);
        tvVerdeConVm = getView().findViewById(R.id.tvVerdeConVm);
        tvVerdeSinVm = getView().findViewById(R.id.tvVerdeSinVm);


        btnVerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = "";
                for (int i = 0; i < userAlmiList.size(); i++) {
                    texto += userAlmiList.get(i).getNombre() + " " + userAlmiList.get(i).getEdad() + "\n";
                    tvVerdeSinVm.setText(texto);
                    texto = "";
                    for (UserAlmi user : mViewModel.getUserList()) {
                        texto += user.getNombre() + " " + user.getEdad() + "\n";

                    }
                    tvVerdeConVm.setText(texto);
                }
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserAlmi user = new UserAlmi(etNombre.getText().toString(), etEdad.getText().toString());
                userAlmiList.add(user);
                etNombre.setText("");
                etEdad.setText("");

            }
        });

    }

}