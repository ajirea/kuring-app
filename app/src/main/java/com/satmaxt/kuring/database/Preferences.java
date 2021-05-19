package com.satmaxt.kuring.database;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    private static final String PREF_TOKEN = "com.satmaxt.kuring.sharedpreferences";

    private static final String WALKED_STATUS = "WALKED_STATUS";

    private Context context;
    private final SharedPreferences preferences;
    private final SharedPreferences.Editor editor;

    public Preferences(Context context) {
        this.context = context;
        preferences = this.context.getSharedPreferences(PREF_TOKEN, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void setWalkedStatus(boolean status) {
        editor.putBoolean(WALKED_STATUS, status);
        editor.apply();
    }

    public boolean getWalkedStatus() {
        return preferences.getBoolean(WALKED_STATUS, false);
    }
}
