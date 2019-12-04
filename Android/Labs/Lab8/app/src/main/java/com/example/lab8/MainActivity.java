package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Spinner movieSpinner;
    //Activity
    private FavHoliday myFavHoliday = new FavHoliday();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieSpinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);

        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findHoliday(v);
            }
        };

        //add listener to button
        button.setOnClickListener(onclick);

    }

    private void findHoliday(View view){
        Integer movie = movieSpinner.getSelectedItemPosition();
        myFavHoliday.setHoliday(movie);
        String suggestedHoliday = myFavHoliday.getHoliday();
        String suggestedFoods = myFavHoliday.getHolidayFoodURL();
        Log.i("holiday suggested", suggestedHoliday);
        Log.i("suggested foods", suggestedFoods);

        //explicit intent
        Intent intent= new Intent (this, HolidayFind.class);
        intent.putExtra("holidayName", suggestedHoliday);
        intent.putExtra("holidayFoodSuggest", suggestedFoods);
        startActivity(intent);
    }
}
