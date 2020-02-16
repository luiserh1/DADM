package com.luiserh1.dadm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void handleClick(View v) {
        Intent newActivityIntent = null;
        switch (v.getId()) {
            case R.id.butGetQuotation:
                newActivityIntent = new Intent(getApplicationContext(), QuootationActivity.class);
                break;
            case R.id.butFavQuotations:
                newActivityIntent = new Intent(getApplicationContext(), FavouriteActivity.class);
                break;
            case R.id.butSettings:
                newActivityIntent = new Intent(getApplicationContext(), SettingsActivity.class);
                break;
            case R.id.butAbout:
                newActivityIntent = new Intent(getApplicationContext(), AboutActivity.class);
                break;
        }
        if (newActivityIntent != null) {
            startActivity(newActivityIntent);
        }
    }

}
