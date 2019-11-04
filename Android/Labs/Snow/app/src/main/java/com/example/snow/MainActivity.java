package com.example.snow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void snowLove(View view) {
        //editText
        EditText snowC = findViewById(R.id.editText);
        String colorValue = snowC.getText().toString();

        if(colorValue.equalsIgnoreCase("yellow")) {
            //imageView
            ImageView dogSnow = findViewById(R.id.imageView);
            dogSnow.setImageResource(R.drawable.dogpee);
            //textView
            TextView yellowSnowText = findViewById(R.id.message);
            yellowSnowText.setText("Don't eat the " + colorValue.toLowerCase() + " snow! Ew!");
        } else if(colorValue.equalsIgnoreCase("purple")){
            //imageView
            ImageView prettySnow = findViewById(R.id.imageView);
            prettySnow.setImageResource(R.drawable.prettysnow);
            //textView
            TextView purpleSnowText = findViewById(R.id.message);
            purpleSnowText.setText("Light must be hitting the " + colorValue.toLowerCase() + " snow just right!");
        } else if(colorValue.equalsIgnoreCase("red")){
            //imageView
            ImageView bloodSnow = findViewById(R.id.imageView);
            bloodSnow.setImageResource(R.drawable.bloodsnow);
            //textView
            TextView redSnowText = findViewById(R.id.message);
            redSnowText.setText("All this dryness, I got a bloody nose and made the snow " + colorValue.toLowerCase() + "!");
        } else if(colorValue.equalsIgnoreCase("blue")){
            //imageView
            ImageView blueSnow = findViewById(R.id.imageView);
            blueSnow.setImageResource(R.drawable.bluesnow);
            //textView
            TextView blueSnowText = findViewById(R.id.message);
            blueSnowText.setText("I'm " + colorValue.toLowerCase() + " dabode daboda!");
        } else if(colorValue.equalsIgnoreCase("green")){
            //imageView
            ImageView greenSnow = findViewById(R.id.imageView);
            greenSnow.setImageResource(R.drawable.greensnow);
            //textView
            TextView greenSnowText = findViewById(R.id.message);
            greenSnowText.setText("Is it actually snowing if it is this " + colorValue.toLowerCase() + "?");
        } else if(colorValue.equalsIgnoreCase("orange")){
            //imageView
            ImageView orangeSnow = findViewById(R.id.imageView);
            orangeSnow.setImageResource(R.drawable.orangesnow);
            //textView
            TextView orangeSnowText = findViewById(R.id.message);
            orangeSnowText.setText("I'm " + colorValue.toLowerCase() + " dabode daboda!");
        } else if(colorValue.equalsIgnoreCase("black")){
            //imageView
            ImageView blackSnow = findViewById(R.id.imageView);
            blackSnow.setImageResource(R.drawable.bluesnow);
            //textView
            TextView blackSnowText = findViewById(R.id.message);
            blackSnowText.setText("Spooky season means " + colorValue.toLowerCase() + " snow!");
        } else {
            //imageView
            ImageView ghost = findViewById(R.id.imageView);
            ghost.setImageResource(R.drawable.snowflakereal);
            //textView
            TextView snowText = findViewById(R.id.message);
            snowText.setText("Let it snow " + colorValue.toLowerCase() + " snow!");
        }
    }
}
