package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private TextView restaurantSelection;
    private ToggleButton toggle;
    private Spinner nationality;
    private RadioGroup cost;
    private CheckBox bCheckBox;
    private CheckBox lCheckBox;
    private CheckBox dCheckBox;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get views
        restaurantSelection = findViewById(R.id.restTextView);
        toggle = findViewById(R.id.toggleButton);
        nationality = findViewById(R.id.spinner);
        cost = findViewById(R.id.radioGroup);
        bCheckBox = findViewById(R.id.checkBox);
        lCheckBox = findViewById(R.id.checkBox2);
        dCheckBox = findViewById(R.id.checkBox3);

        if (savedInstanceState !=null) {
            message = savedInstanceState.getString("msg");

            restaurantSelection.setText(message);
        }
    }
    public void findRestauarant(View view) {
        //toggle button
        boolean location = toggle.isChecked();

        //spinner
        String nationalityType = String.valueOf(nationality.getSelectedItem());

        //radio buttons
        int cost_id = cost.getCheckedRadioButtonId();

        //check boxes
        Boolean breakfast = bCheckBox.isChecked();
        Boolean lunch = lCheckBox.isChecked();
        Boolean dinner = dCheckBox.isChecked();

        //pick sport
        String perfectRestaurant;

        //check radio buttons
        if (cost_id == -1) {
            //toast
            Context context = getApplicationContext();
            CharSequence text = "Please select a desired price level.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else if(cost_id== R.id.radioButton && !location){
            //toast
            Context context = getApplicationContext();
            CharSequence text = "The selected price level does not have sit down restaurant options.";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            if (location) { //fast food
                if (cost_id == R.id.radioButton) { //cheapest option=fastfood
                    switch (nationalityType) {
                        case "American":
                            perfectRestaurant = "McDonald's";
                            break;
                        case "Asian":
                            perfectRestaurant = "Panda Express";
                            break;
                        case "Italian":
                            perfectRestaurant = "D'Angelo's Italian Deli";
                            break;
                        case "Mexican":
                            perfectRestaurant = "Taco Bell";
                            break;
                        case "Greek":
                            perfectRestaurant = "Garbanzo Mediterranean Fresh";
                            break;
                        default:
                            perfectRestaurant = "Wendy's";
                    }
                    //text view
                    message = perfectRestaurant + " is the restaurant for you!";
                    restaurantSelection.setText(message);
                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "With fast food selected, you must select the lowest price level.";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            } else { //sitdown
                if (cost_id == R.id.radioButton2) {
                    if (breakfast) {
                        switch (nationalityType) {
                            case "American":
                                perfectRestaurant = "Snooze";
                                break;
                            case "Asian":
                                perfectRestaurant = "Chez Thuy Restaurant";
                                break;
                            case "Italian":
                                perfectRestaurant = "Ado's Kitchen and Bar";
                                break;
                            case "Mexican":
                                perfectRestaurant = "Santiago's Mexican Restaurant";
                                break;
                            case "Greek":
                                perfectRestaurant = "The Med";
                                break;
                            default:
                                perfectRestaurant = "The Buff";
                        }
                    } else {
                        switch (nationalityType) {
                            case "American":
                                perfectRestaurant = "Next Door American Eatery";
                                break;
                            case "Asian":
                                perfectRestaurant = "Aloy Thai Cuisine";
                                break;
                            case "Italian":
                                perfectRestaurant = "Pizzeria Locale";
                                break;
                            case "Mexican":
                                perfectRestaurant = "Qdoba";
                                break;
                            case "Greek":
                                perfectRestaurant = "Falafel King Restaurant";
                                break;
                            default:
                                perfectRestaurant = "The Sink";
                        }
                    }
                } else {
                    if (breakfast) {
                        switch (nationalityType) {
                            case "American":
                                perfectRestaurant = "Jill's Restaurant";
                                break;
                            case "Asian":
                                perfectRestaurant = "Kung Fu Tea";
                                break;
                            case "Italian":
                                perfectRestaurant = "Ado's Kitchen and Bar";
                                break;
                            case "Mexican":
                                perfectRestaurant = "La Cocina De Mama";
                                break;
                            case "Greek":
                                perfectRestaurant = "Ali Baba Grill";
                                break;
                            default:
                                perfectRestaurant = "The Kitchen American Bistro";
                        }
                    } else if (lunch) {
                        switch (nationalityType) {
                            case "American":
                                perfectRestaurant = "The Boulder Cork";
                                break;
                            case "Asian":
                                perfectRestaurant = "Hana Sushi";
                                break;
                            case "Italian":
                                perfectRestaurant = "Via Perla";
                                break;
                            case "Mexican":
                                perfectRestaurant = "Rio Grande Mexican Restaurant";
                                break;
                            case "Greek":
                                perfectRestaurant = "Kalita Grill Greek Cafe";
                                break;
                            default:
                                perfectRestaurant = "Brasserie Ten Ten";
                        }
                    } else {
                        switch (nationalityType) {
                            case "American":
                                perfectRestaurant = "Oak on 14th";
                                break;
                            case "Asian":
                                perfectRestaurant = "Izakaya Amu";
                                break;
                            case "Italian":
                                perfectRestaurant = "Frasca Food and Wine";
                                break;
                            case "Mexican":
                                perfectRestaurant = "Tahona Tequila Bistro";
                                break;
                            case "Greek":
                                perfectRestaurant = "Kalita Grill Greek Cafe";
                                break;
                            default:
                                perfectRestaurant = "Flagstaff House";
                        }
                    }
                }

                //text view
                message = perfectRestaurant + " is the restaurant for you!";
                restaurantSelection.setText(message);
            }
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("msg", message);
    }
}
