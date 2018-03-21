package com.example.redditdemo.utility;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.redditdemo.ApplicationClass;
import com.google.gson.Gson;

public class PreferencesManager {

    public static final String PREFERENCES = "app_preferences";


    public static SharedPreferences getPreferences() {
        return ApplicationClass.getInstance().getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
    }

    public static SharedPreferences.Editor getEditor() {
        return getPreferences().edit();
    }

    public static void removePreference(String preferenceName) {
        getEditor().remove(preferenceName);
    }

    public static <T> T loadObject(String preferenceName, Class<T> type, T defValue) {
        T object = defValue;
        Gson gson = new Gson();
        String json = loadString(preferenceName, null);
        if (json != null) {
            object = gson.fromJson(json, type);
        }
        return object;
    }

    public static void saveObject(String preferenceName, Object object) {
        Gson gson = new Gson();
        String json = gson.toJson(object);
        saveString(preferenceName, json);
    }

    public static String loadString(String preferenceName, String defValue) {
        SharedPreferences sharedPreferences = getPreferences();
        return sharedPreferences.getString(preferenceName, defValue);
    }

    public static void saveString(String preferenceName, String value) {
        getEditor().putString(preferenceName, value).apply();
    }

    public static int loadInt(String preferenceName, int defValue) {
        SharedPreferences sharedPreferences = getPreferences();
        return sharedPreferences.getInt(preferenceName, defValue);
    }

    public static void saveInt(String preferenceName, int value) {
        getEditor().putInt(preferenceName, value).apply();
    }

    public static long loadLong(String preferenceName, long defValue) {
        SharedPreferences sharedPreferences = getPreferences();
        return sharedPreferences.getLong(preferenceName, defValue);
    }

    public static void saveLong(String preferenceName, long value) {
        getEditor().putLong(preferenceName, value).apply();
    }

    public static boolean loadBoolean(String preferenceName, boolean defValue) {
        SharedPreferences sharedPreferences = getPreferences();
        return sharedPreferences.getBoolean(preferenceName, defValue);
    }

    public static void saveBoolean(String preferenceName, boolean value) {
        getEditor().putBoolean(preferenceName, value).apply();
    }
}