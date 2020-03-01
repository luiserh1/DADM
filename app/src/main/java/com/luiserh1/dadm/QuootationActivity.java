package com.luiserh1.dadm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuootationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quootation);
        TextView infoText = findViewById(R.id.tvQuoteFavQuotation);
        infoText.setText(getString(R.string.get_quotation_info, "Nameless One"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_quotation, menu);
        return true; // A good implementation should have try-catch
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_to_favourite:
                return true;
            case R.id.get_another_quotation:
                refresh();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }

    public void refresh() {
        TextView quoteText = findViewById(R.id.tvQuoteFavQuotation);
        quoteText.setText(getString(R.string.get_quotation_sample_quotation));
        TextView authorText = findViewById(R.id.tvAuthorFavQuotation);
        authorText.setText(getString(R.string.get_quotation_author));
    }
}
