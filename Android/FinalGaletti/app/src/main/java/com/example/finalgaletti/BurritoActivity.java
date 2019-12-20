package com.example.finalgaletti;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class BurritoActivity extends AppCompatActivity {
    private String burritoShop;
    private String burritoShopURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burrito);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadWebSite(view);
            }
        });

        //implicit intent
        Intent intent = getIntent();
        burritoShop = intent.getStringExtra("burritoShopName");
        burritoShopURL = intent.getStringExtra("burritoShopURL");
        Log.i("shop received", burritoShop);
        Log.i("url received", burritoShopURL);

        //update textview
        TextView messageView = findViewById(R.id.burritoShopTextView);
        messageView.setText("You should check out "+ burritoShop);
    }

    private void loadWebSite(View view){
        Intent intent = new Intent((Intent.ACTION_VIEW));
        intent.setData(Uri.parse(burritoShopURL));
        startActivity(intent);
    }

}
