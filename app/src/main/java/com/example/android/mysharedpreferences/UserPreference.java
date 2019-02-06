package com.example.android.mysharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreference {
    private static final String PREFS_NAME = "user_pref";

    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String AGE = "age";
    private static final String PHONE_NUMBER = "phone";
    private static final String LOVE_MU = "isLove";

    private final SharedPreferences preferences;

    UserPreference(Context context){
        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    // Method setter dan getter untuk menyimpan dan membaca data
    public void setUser(UserModel value){
        // Membuat editor untuk menyimpan nilai
        SharedPreferences.Editor editor = preferences.edit();
        // Menyimpan nilai
        editor.putString(NAME, value.name);
        editor.putString(EMAIL, value.email);
        editor.putInt(AGE, value.age);
        editor.putString(PHONE_NUMBER, value.phoneNumber);
        editor.putBoolean(LOVE_MU, value.isLove);
        // Menyimpan data
        editor.apply();
    }

    UserModel getUser(){
        UserModel model = new UserModel();
        // Membaca data
        model.setName(preferences.getString(NAME, ""));
        model.setEmail(preferences.getString(EMAIL, ""));
        model.setAge(preferences.getInt(AGE, 0));
        model.setPhoneNumber(preferences.getString(PHONE_NUMBER, ""));
        model.setLove(preferences.getBoolean(LOVE_MU, false));
        return model;
    }
}
