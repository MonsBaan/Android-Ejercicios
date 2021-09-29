package com.example.proyectoindividual.bbddUser;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.proyectoindividual.bbdd.AppDatabase;
import com.example.proyectoindividual.bbdd.ImagenDao;
import com.example.proyectoindividual.bbddUser.model.Usuario;

@Database(entities = {Usuario.class}, version = 1, exportSchema = false)
public abstract class AppDatabaseUser extends RoomDatabase {
    private static final String LOG_TAG = AppDatabaseUser.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "UsuariosDB";
    private static AppDatabaseUser sInstance;

    public static AppDatabaseUser getInstance(Context context){
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d("db", LOG_TAG);

                Log.d(LOG_TAG, "Creando BBDD User");
                sInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabaseUser.class,
                        AppDatabaseUser.DATABASE_NAME).fallbackToDestructiveMigration().build();
            }
        }
        return sInstance;
    }


    public abstract UsuarioDao UsuarioDao();


}
