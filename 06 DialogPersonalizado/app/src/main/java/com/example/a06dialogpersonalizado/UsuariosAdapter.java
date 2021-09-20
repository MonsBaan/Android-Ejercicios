package com.example.a06dialogpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a06dialogpersonalizado.model.Usuario;

import java.util.List;

public class UsuariosAdapter extends ArrayAdapter {
    private Context context;
    private List<Usuario> mUsuarioList;

    public UsuariosAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public int getCount() {
        return mUsuarioList.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return mUsuarioList.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false);

        TextView tvUsuario = (TextView) view;
        tvUsuario.setText(mUsuarioList.get(position).getUsuario());
        return view;
    }

    public void setmUsuarioList(List<Usuario> mUsuarioList) {
        this.mUsuarioList = mUsuarioList;
    }

    public List<Usuario> getmUsuarioList() {
        return mUsuarioList;
    }
}
