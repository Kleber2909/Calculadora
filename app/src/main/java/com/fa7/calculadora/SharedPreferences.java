package com.fa7.calculadora;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Kleber on 05/05/2018.
 */

class ExemploSharedPreferences {

    private static final  String prefsName = "DefaulltPrefs";

    public static void  saveText(Context context, String key, String value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(prefsName, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public  static String getText(Context context, String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(prefsName, 0);
        return sharedPreferences.getString(key, "");
    }
}
