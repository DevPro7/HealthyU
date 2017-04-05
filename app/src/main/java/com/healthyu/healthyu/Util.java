package com.healthyu.healthyu;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


/**
 * Created by Marina on 4/4/2017.
 */

public class Util
{
    public static void putKey(String key, String value,SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static  String getValue(String key, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        return sharedPreferences.getString(key, "0");
    }

    public static void updateKey(String key, String newvalue, SharedPreferences mypref)
    {//??? working
        SharedPreferences.Editor prefsEditr = mypref.edit();
        prefsEditr.putString(key, newvalue);
        prefsEditr.apply();
    }
}
