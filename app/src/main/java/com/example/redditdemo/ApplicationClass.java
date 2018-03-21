package com.example.redditdemo;

import android.app.Application;
import android.content.Context;

public class ApplicationClass extends Application {

    private static Context instance;

    public static synchronized Context getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
