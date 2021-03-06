package com.everacosta.misspets.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.everacosta.misspets.R;

public class preferencesUtils {
    public static boolean saveToken (String token, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.TOKEN, token);
        prefsEditor.apply();
        return true;
    }
    public  static String getToken (Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.TOKEN, null);
    }
}
