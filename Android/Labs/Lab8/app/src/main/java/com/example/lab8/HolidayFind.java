package com.example.lab8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.widget.Toolbar;

public class HolidayFind extends AppCompatActivity {
    private String holiday;
    private String holidayFoodURL;
    private String holidayImage;
    private String holidayImageName;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holidayfind);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                loadRecipe(view);
            }
        });

        Intent intent = getIntent();
        holiday = intent.getStringExtra("holidayName");
        holidayFoodURL = intent.getStringExtra("holidayFoodSuggest");
        Log.i("holiday received", holiday);
        Log.i("recipe received", holidayFoodURL);

        // update text view
        TextView messageView = findViewById(R.id.holidayTextView);
        messageView.setText("You probably already knew this, but your favorite holiday is " + holiday);

        ImageView imageSet = findViewById(R.id.holidayImageView);
       if(holiday.equals("Christmas")){
           imageSet.setImageResource(R.drawable.christmas);
       } else if(holiday.equals("Thanksgiving")){
           imageSet.setImageResource(R.drawable.thanksgiving);
       } else if(holiday.equals("Easter")){
           imageSet.setImageResource(R.drawable.easter);
       } else if(holiday.equals("Halloween")){
           imageSet.setImageResource(R.drawable.halloween);
       } else if(holiday.equals("Valentine\'s Day")){
           imageSet.setImageResource(R.drawable.love);
       } else if(holiday.equals("New Year")){
           imageSet.setImageResource(R.drawable.celebration);
       } else if(holiday.equals("July 4th")){
           imageSet.setImageResource(R.drawable.drunk);
       } else{
           imageSet.setImageResource(R.drawable.potato);
       }

    }

    private void loadRecipe(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //inmutable reference to a resource or data
        intent.setData(Uri.parse(holidayFoodURL));
        startActivity(intent);
    }

}

