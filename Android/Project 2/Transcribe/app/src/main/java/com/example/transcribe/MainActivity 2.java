package com.example.transcribe;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.speech.RecognizerIntent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //Speech that will be put into text in the text view
    private TextView textTranscribed;
    //Controlling the image shown in the button image
    private ImageButton recordButton;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    private ImageButton deleteButton;
    private String message;

    boolean isRecording = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTranscribed = (TextView) findViewById(R.id.textTranscribed);
        recordButton = (ImageButton) findViewById(R.id.recordButton);
        deleteButton = (ImageButton) findViewById(R.id.deleteButton);

        // check for recovering the instance state
        if (savedInstanceState != null) {
            message = savedInstanceState.getString("msg");
            textTranscribed.setText(message);
        }


        deleteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textTranscribed.setText("");
                //toast
                Context context = getApplicationContext();
                CharSequence text = "Transcribed text deleted.";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        recordButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(isRecording){
                    recordButton.setImageResource(R.drawable.logo);
                    isRecording=false;
                } else {
                    recordButton.setImageResource(R.drawable.stop);
                    isRecording=true;
                }
                promptSpeechTranscription();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareText(textTranscribed.getText().toString());
            }
        });
    }

    //referenced code from: code.tutsplus.com/tutorials/android-sdk-implement-a-share-intent--mobile-8433
    private void shareText(String transcribeSave) {
        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, transcribeSave);
        startActivity(Intent.createChooser(intent, "Share via"));
    }
    private void promptSpeechTranscription(){
        //Create an intent to establish the start of activity
        //Library used below to allow accessibility to speech recognition
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        //Additional necessity of library
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        //Accessing the language that is used by the user and setting that to default so the transcription is accurate
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    //Receiving speech input
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textTranscribed.setText(result.get(0));
                    //shareText(textTranscribed.getText().toString());
                }
                isRecording = false;
                recordButton.setImageResource(R.drawable.logo);
                break;
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("msg", textTranscribed.getText().toString());
    }
}
