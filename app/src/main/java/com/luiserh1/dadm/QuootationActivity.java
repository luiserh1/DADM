package com.luiserh1.dadm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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

    public void handleClick(View v) {
        TextView quoteText = findViewById(R.id.tvQuoteFavQuotation);
        quoteText.setText(getString(R.string.get_quotation_sample_quotation));
        TextView authorText = findViewById(R.id.tvAuthorFavQuotation);
        authorText.setText(getString(R.string.get_quotation_author));
    }
}
