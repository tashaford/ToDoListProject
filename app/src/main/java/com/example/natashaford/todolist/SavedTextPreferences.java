package com.example.natashaford.todolist;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by natashaford on 07/07/2017.
 */

public class SavedTextPreferences {

    private static final String PREF_SAVEDTITLE = "saved title";
    private static final String PREF_SAVEDDETAILS = "saved details";

    public static void setStoredTitle(Context context, String text){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(PREF_SAVEDTITLE, text);
        editor.apply();
    }

    public static void setStoredDetails(Context context, String text){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(PREF_SAVEDDETAILS, text);
        editor.apply();
    }

    public static String getStoredTitle(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(PREF_SAVEDTITLE, null);
    }

    public static String getStoredDetails(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(PREF_SAVEDDETAILS, null);
    }
}
