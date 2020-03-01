package com.luiserh1.dadm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.luiserh1.dadm.adapter.FavouriteAdapter;
import com.luiserh1.dadm.pojo.Quotation;

import java.util.ArrayList;

public class FavouriteActivity extends AppCompatActivity {

    FavouriteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        adapter = new FavouriteAdapter(getMockQuotations(),
            new FavouriteAdapter.OnItemClickListener() {
                @Override
                public void onItemClickListener(int position) {
                    Quotation quotation = adapter.getQuotationFromPosition(position);

                    Intent impIntent = new Intent();
                    impIntent.setAction(Intent.ACTION_VIEW);
                    String author = quotation.getQuoteAuthor();

                    if (author == null || author == "") { // Anonymous author
                        Toast.makeText(getApplicationContext(),
                                "The author of this quotation is anonymous",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }

                    impIntent.setData(Uri.parse("https://en.wikipedia.org/wiki/Special:Search?search=" + author));
                    if (impIntent.resolveActivity(getPackageManager()) != null) {
                        Intent chooser = Intent.createChooser(impIntent,
                                String.format("View %s's Wikipedia page", author));
                        startActivity(chooser);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "There is no application capable of handling this action",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            },
            new FavouriteAdapter.OnItemLongClickListener() {
                @Override
                public void onItemLongClickListener(int position) {
                    showDeletionDialogue(position);
                }
            }
        );
        RecyclerView rcv = findViewById(R.id.rvFavouriteQuotations);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcv.setLayoutManager(manager);

        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(
                getApplicationContext(), LinearLayoutManager.VERTICAL);
        rcv.addItemDecoration(decoration);

        rcv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_favourite, menu);

        // This has to be done after inflating the XML into a view
        // otherwise there will be no Java object to call
        if (adapter.getItemCount() < 1) {
            menu.findItem(R.id.delete_all).setVisible(false);
        }
        return true; // A good implementation should have try-catch
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_all:
                showClearAllDialogue();
            default:
                return super.onOptionsItemSelected(item);
        }
        //return false;
    }

    private void showDeletionDialogue(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(FavouriteActivity.this);
        builder.setIcon(android.R.drawable.stat_sys_warning);
        builder.setTitle(R.string.deletion_dialog_title);
        builder.setMessage(R.string.deletion_dialog_message);
        builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(FavouriteActivity.this, R.string.deletion_dialog_no, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                adapter.removeQuotationFromPosition(position);
                Toast.makeText(FavouriteActivity.this, R.string.deletion_dialog_yes, Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    private void showClearAllDialogue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(FavouriteActivity.this);
        builder.setIcon(android.R.drawable.stat_sys_warning);
        builder.setTitle(R.string.clear_all_dialog_title);
        builder.setMessage(R.string.clear_all_dialog_message);
        builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(FavouriteActivity.this, R.string.clear_all_dialog_no, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                adapter.removeAllQuotations();
                Toast.makeText(FavouriteActivity.this, R.string.clear_all_dialog_yes, Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
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

    ArrayList<Quotation> getMockQuotations() {
        ArrayList<Quotation> res = new ArrayList<Quotation>();
        res.add(new Quotation("1234567890", ""));
        res.add(new Quotation("To do is to be", "Kant"));
        res.add(new Quotation("To be is to do", "Descartes"));
        res.add(new Quotation("Doo be do be doo", "Scooby Doo"));
        res.add(new Quotation("Las circustancias de nuestro nacimiento son irrelevantes, es lo que decidas hacer con el regalo de la vida lo que determina quien eres", "Mewtwo"));
        res.add(new Quotation("Las rosas son rojas, las violetas azules, por favor, dame algo de comer", "Heinz Doofensmirth"));
        res.add(new Quotation("La vida son dos días", "Una mosca"));
        res.add(new Quotation("Poyo!", "Kirby"));
        res.add(new Quotation("Cuando amas lo que tienes tienes todo lo que quieres", "Anónimo"));
        res.add(new Quotation("Si yo fuera humano tendría una súper mega fuente de jamón", "La rana del anuncio de Campofrío"));
        return res;
    }
}
