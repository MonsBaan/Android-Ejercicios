package com.example.a06dialogpersonalizado;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a06dialogpersonalizado.bbdd.AppDatabase;
import com.example.a06dialogpersonalizado.bbdd.AppExecutors;
import com.example.a06dialogpersonalizado.model.Usuario;

import java.util.List;

public class ActivityRegister extends AppCompatActivity {
    private ListView lvUsers = null;
    private EditText etNombre, etPass, etRePass = null;
    private Button btnRegistrar, btnUpdate = null;

    private int identificador = -1;
    private Intent intent = null;
    private AppDatabase mDb = null;
    private UsuariosAdapter usuariosAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mDb = AppDatabase.getInstance(getApplicationContext());
        intent = getIntent();


        Toast.makeText(getApplicationContext(), "BBDD Preparada", Toast.LENGTH_SHORT).show();
        lvUsers = findViewById(R.id.lvUsers);
        etNombre = findViewById(R.id.tilRegistrarUser);
        etPass = findViewById(R.id.tilRegistrarPass);
        etRePass = findViewById(R.id.tilRegistrarRePass);

        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnUpdate = findViewById(R.id.btnUpdateUsuario);
        usuariosAdapter = new UsuariosAdapter(getApplicationContext(), 1);
        lvUsers.setAdapter(usuariosAdapter);
        final AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        lvUsers.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                alerta.setTitle("GUACHO QUE LA LIAS");
                alerta.setMessage("QUE VAS A BORRAR ESTO");
                final int idEliminar = ((Usuario) usuariosAdapter.getItem(i)).getId();
                alerta.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "No se ha eliminado", Toast.LENGTH_SHORT).show();
                    }
                });
                alerta.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        eliminar(idEliminar);
                    }
                });

                alerta.show();
                return true;
            }
        });
        lvUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                identificador = ((Usuario) usuariosAdapter.getItem(i)).getId();
                etNombre.setText(((Usuario) usuariosAdapter.getItem(i)).getUsuario());
                etPass.setText(((Usuario) usuariosAdapter.getItem(i)).getPassword());
                etRePass.setText(((Usuario) usuariosAdapter.getItem(i)).getPassword());

            }
        });
        etRePass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String password =  etPass.getText().toString();
                String rePassword = etRePass.getText().toString();

                if (!password.equals(rePassword)){
                    btnRegistrar.setEnabled(false);
                    etRePass.setBackgroundColor(Color.RED);
                }else{
                    btnRegistrar.setEnabled(true);
                    etRePass.setBackgroundColor(Color.WHITE);
                }
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = etNombre.getText().toString();
                String pass = etPass.getText().toString().trim();

                actualizar(identificador, user, pass);
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = etNombre.getText().toString();
                String pass = etPass.getText().toString().trim();

                if (pass.equals(etRePass.getText().toString().trim())) {
                    guardar(user, pass);
                    Toast.makeText(getApplicationContext(), "Usuario Creado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void eliminar(int id) {
        AppExecutors.getInstance().getDiskIP().execute(new Runnable() {
            @Override
            public void run() {
                Usuario usu = mDb.usuariosDao().loadUsuarioById(id);
                mDb.usuariosDao().deleteUsuario(usu);
            }
        });
    }

    private void actualizar(int id, String user, String password) {
        AppExecutors.getInstance().getDiskIP().execute(new Runnable() {
            @Override
            public void run() {
                Usuario usu = mDb.usuariosDao().loadUsuarioById(id);
                usu.setUsuario(user);
                usu.setPassword(password);
                mDb.usuariosDao().updateUsuario(usu);
            }
        });

    }

    private void guardar(String user, String password) {
        final Usuario usuario = new Usuario(user, password);
        AppExecutors.getInstance().getDiskIP().execute(new Runnable() {
            @Override
            public void run() {
                mDb.usuariosDao().insertUsuario(usuario);
            }
        });
    }

    private void consultar() {
        mDb.usuariosDao().loadAllUsuarios().observe(this, new Observer<List<Usuario>>() {
            @Override
            public void onChanged(List<Usuario> usuarios) {
                usuariosAdapter.setmUsuarioList(usuarios);
            }
        });
    }

    @Override
    protected void onResume() {

        super.onResume();
        consultar();
    }
}