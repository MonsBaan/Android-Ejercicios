package com.example.proyectoindividual.bbdd;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutorsGallery {
    private static final Object LOCK = new Object();
    private static AppExecutorsGallery sInstance;
    private Executor diskIP = null;
    private Executor mainThread = null;
    private Executor networkIO = null;

    private static class MainThreadExecutor implements Executor {
        private android.os.Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(Runnable command) {
            mainThreadHandler.post(command);
        }
    }

    private AppExecutorsGallery(Executor diskIP, Executor mainThread, Executor networkIO) {
        this.diskIP = diskIP;
        this.mainThread = mainThread;
        this.networkIO = networkIO;
    }

    public static AppExecutorsGallery getInstance() {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new AppExecutorsGallery(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(3), new MainThreadExecutor());
            }
        }
        return sInstance;
    }

    public Executor getDiskIP() {
        return diskIP;
    }

    public Executor getMainThread() {
        return mainThread;
    }

    public Executor getNetworkIO() {
        return networkIO;
    }
}
