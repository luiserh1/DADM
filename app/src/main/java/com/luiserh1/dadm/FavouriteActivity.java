package com.luiserh1.dadm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FavouriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
    }

    public void handleClick(View v) {
        Intent impIntent = new Intent();
        impIntent.setAction(Intent.ACTION_VIEW);
        String author = "Albert Einstein";
        impIntent.setData(Uri.parse("https://en.wikipedia.org/wiki/Special:Search?search=" + author));
        if (impIntent.resolveActivity(getPackageManager()) != null) {
            Intent chooser = Intent.createChooser(impIntent,
                    String.format("View %s's Wikipedia page", author));
            startActivity(chooser);
        }
        else {
            Toast.makeText(getApplicationContext(),
                    "There is no application capable of handling this action",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
