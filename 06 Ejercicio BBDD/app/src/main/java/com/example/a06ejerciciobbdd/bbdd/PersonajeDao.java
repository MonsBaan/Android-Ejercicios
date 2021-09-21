package com.example.a06ejerciciobbdd.bbdd;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.a06ejerciciobbdd.model.Personaje;

import java.util.List;

@Dao
public interface PersonajeDao {
    @Query("SELECT * FROM Personaje ORDER BY ID")
    LiveData<List<Personaje>> loadAllPersonajes();

    @Insert
    void insertPersonaje(Personaje personaje);

    @Delete
    void deletePersonaje(Personaje personaje);

    @Query("SELECT * FROM Personaje WHERE id =:id")
    Personaje loadPersonajeById(int id);
}
