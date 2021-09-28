package com.example.proyectoindividual.bbdd;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.proyectoindividual.bbdd.model.Imagen;

import java.util.List;

@Dao
public interface ImagenDao {
    @Query("SELECT * FROM Imagen ORDER BY ID")
    LiveData<List<Imagen>> loadAllImages();

    @Insert
    void insertNewImage(Imagen imagen);

    @Delete
    void deleteImage(Imagen imagen);

    @Query("SELECT * FROM Imagen WHERE id=:id")
    Imagen loadImagenById(int id);

    @Query("SELECT * FROM Imagen WHERE tipoFoto = 0 ORDER BY id")
    LiveData<List<Imagen>> loadInteriorImages();

    @Query("SELECT * FROM Imagen WHERE tipoFoto = 1 ORDER BY id")
    LiveData<List<Imagen>> loadExteriorImages();


}
