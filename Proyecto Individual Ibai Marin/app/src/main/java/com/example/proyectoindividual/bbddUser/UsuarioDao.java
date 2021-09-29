package com.example.proyectoindividual.bbddUser;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.proyectoindividual.bbdd.model.Imagen;
import com.example.proyectoindividual.bbddUser.model.Usuario;

import java.util.List;

@Dao
public interface UsuarioDao {
    @Query("SELECT * FROM Usuario WHERE user=:usu AND pass= :contra")
    abstract Usuario loginUsuario(String usu, String contra);

    @Insert
    void insertUser(Usuario user);
}
