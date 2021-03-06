package com.example.proyectoindividual.bbdd;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.proyectoindividual.bbdd.model.Imagen;

@Database(entities = {Imagen.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String LOG_TAG = AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "ImagenesGaleria";
    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d("db", LOG_TAG);

                Log.d(LOG_TAG, "Creando BBDD");
                sInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,
                        AppDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build();
            }
        }
        return sInstance;
    }

    public abstract ImagenDao imagenDao();
}
