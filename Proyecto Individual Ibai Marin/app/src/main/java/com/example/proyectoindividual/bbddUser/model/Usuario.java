package com.example.proyectoindividual.bbddUser.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Usuario")
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String user, pass;

    public Usuario(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
