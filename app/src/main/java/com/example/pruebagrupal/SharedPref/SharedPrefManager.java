package com.example.pruebagrupal.SharedPref;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.pruebagrupal.Model.UsuarioModel;

public class SharedPrefManager {
    private static final String SHARED_PREFERENCES = "SHARED_PREFERENCES";
    private static final String SHARED_PREFERENCES_ID = "SHARED_PREFERENCES_ID";
    private static final String SHARED_PREFERENCES_NOMBREUSU = "SHARED_PREFERENCES_NOMBREUSU";
    private static final String SHARED_PREFERENCES_CONTRASENIA = "SHARED_PREFERENCES_CONTRASENIA";
    private static final String SHARED_PREFERENCES_TOKEN = "SHARED_PREFERENCES_TOKEN";
    private static final String SHARED_PREFERENCES_ROL = "SHARED_PREFERENCES_ROL";

    private static SharedPrefManager instance;
    private Context context;
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;

    private SharedPrefManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (instance == null)
            instance = new SharedPrefManager(context);
        return instance;
    }

    public void guardarUsuario (UsuarioModel usu) {
        editor.putInt(SHARED_PREFERENCES_ID, usu.getUsuario_id());
        editor.putString(SHARED_PREFERENCES_NOMBREUSU, usu.getUsuario());
        editor.putString(SHARED_PREFERENCES_CONTRASENIA, usu.getContrasenia());
        editor.putString(SHARED_PREFERENCES_TOKEN, usu.getToken());
        editor.putInt(SHARED_PREFERENCES_ROL, usu.getRol_id());
        editor.apply();
    }

    public UsuarioModel getUsuarios() {
        UsuarioModel usu = new UsuarioModel(
                sharedPreferences.getInt(SHARED_PREFERENCES_ID, -1),
                sharedPreferences.getString(SHARED_PREFERENCES_NOMBREUSU, null),
                sharedPreferences.getString(SHARED_PREFERENCES_CONTRASENIA, null),
                sharedPreferences.getString(SHARED_PREFERENCES_TOKEN, null),
                sharedPreferences.getString(SHARED_PREFERENCES_ROL, null)
        );
        return usu;
    }
}
