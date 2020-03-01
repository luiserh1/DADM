package com.luiserh1.dadm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settingsLayout, new SettingsFragment())
                .commit();


        /*SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        EditText et = findViewById(R.id.etName);
        String userName = prefs.getString("username", "");
        et.setText(userName);*/
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();


        /*EditText et = findViewById(R.id.etName);
        if (et != null && et.getText().toString().length() > 0) {
            editor.putString("username", et.getText().toString());
        } else {
            editor.remove("username");
        }
        editor.apply();*/
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.preferences_settings, rootKey);
        }
    }
}
