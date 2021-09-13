package com.example.a02ejerciciohilos;

import java.util.concurrent.Executor;

public class EjecutarHilo implements Executor {
    @Override
    public void execute(Runnable runnable) {
        new Thread(runnable).start();
    }
}
