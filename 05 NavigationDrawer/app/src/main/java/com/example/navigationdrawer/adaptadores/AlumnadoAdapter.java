package com.example.navigationdrawer.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.navigationdrawer.Alumnado;
import com.example.navigationdrawer.R;

public class AlumnadoAdapter extends ArrayAdapter {
    private Alumnado alumnado = null;
    private Context context;

    public AlumnadoAdapter(@NonNull Context context, int resource, Alumnado alu) {
        super(context, resource);
        this.alumnado = alu;
        this.context = context;
    }

    @Override
    public int getCount() {
        return alumnado.getAlumnado().size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return alumnado.getAlumnado().get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vista = inflater.inflate(R.layout.alumno_item, parent, false);
        TextView tvNombre = vista.findViewById(R.id.tvNombreAlumno);
        TextView tvApellidos = vista.findViewById(R.id.tvApellidosAlumno);

        tvNombre.setText(alumnado.getAlumnado().get(position).getNombre());
        tvApellidos.setText(alumnado.getAlumnado().get(position).getApellido1() + " " + alumnado.getAlumnado().get(position).getApellido2());
        return vista;
    }
}
