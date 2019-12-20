package com.example.finalgaletti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggle;
    private TextView suggestedrest;
    private Spinner location;
    private RadioGroup foodType;
    private CheckBox salsaCheckBox;
    private CheckBox sourcreamCheckBox;
    private CheckBox cheeseCheckBox;
    private CheckBox guacCheckBox;
    private String message;
    private Button suggestBurrito;
    private Burrito myBurritoShop = new Burrito();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get views
        suggestedrest = findViewById(R.id.suggestedrestaurant);
        toggle = findViewById(R.id.toggleButton);
        location = findViewById(R.id.spinner);
        foodType = findViewById(R.id.radioGroup);
        salsaCheckBox = findViewById(R.id.checkBox);
        sourcreamCheckBox = findViewById(R.id.checkBox2);
        cheeseCheckBox = findViewById(R.id.checkBox3);
        guacCheckBox = findViewById(R.id.checkBox4);
        suggestBurrito = findViewById(R.id.button2);

        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foundBurritoPlace(v);
            }
        };
        //add listener to button
        suggestBurrito.setOnClickListener(onclick);
    }

    public void findBurrito(View view) {
        boolean protein = toggle.isChecked();

        //spinner
        String locationType = String.valueOf(location.getSelectedItem());

        int foodType_id = foodType.getCheckedRadioButtonId();

        Boolean salsa = salsaCheckBox.isChecked();
        Boolean sourcream = sourcreamCheckBox.isChecked();
        Boolean cheese = cheeseCheckBox.isChecked();
        Boolean guac = guacCheckBox.isChecked();

        String perfectBurrito="";
        String perfectRestaurant="";
        String perfectTopping="";
        ImageView imageSet = findViewById(R.id.imageView);

        if (foodType_id == -1) {
            //toast
            Context context = getApplicationContext();
            CharSequence text = "Please select a type of food - Burrito or Taco";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            //Meat
            if (protein) {
                //Burrito
                if (foodType_id == R.id.radioButton) {
                    imageSet.setImageResource(R.drawable.burrito);
                    if (salsa) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping = "salsa ";
                                perfectBurrito = "meat burrito";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping = "salsa ";
                                perfectBurrito = "meat burrito";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping = "salsa ";
                                perfectBurrito = "meat burrito";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                    if (sourcream) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping += "sour cream ";
                                perfectBurrito = "meat burrito";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping += "sour cream ";
                                perfectBurrito = "meat burrito";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping += "sour cream ";
                                perfectBurrito = "meat burrito";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                    if (cheese) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping += "cheese ";
                                perfectBurrito = "meat burrito";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping += "cheese ";
                                perfectBurrito = "meat burrito";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping += "cheese ";
                                perfectBurrito = "meat burrito";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                    if (guac) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping += "guacamole ";
                                perfectBurrito = "meat burrito";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping += "guacamole ";
                                perfectBurrito = "meat burrito";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping += "guacamole ";
                                perfectBurrito = "meat burrito";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                    if (!guac && !cheese && !sourcream && !salsa) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping = "no toppings";
                                perfectBurrito = "meat burrito";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping = "no toppings";
                                perfectBurrito = "meat burrito";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping = "no toppings";
                                perfectBurrito = "meat burrito";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                } else {
                    imageSet.setImageResource(R.drawable.taco);
                    if (salsa) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping = "salsa ";
                                perfectBurrito = "meat tacos";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping = "salsa ";
                                perfectBurrito = "meat tacos";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping = "salsa ";
                                perfectBurrito = "meat tacos";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                    if (sourcream) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping += "sour cream ";
                                perfectBurrito = "meat tacos";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping += "sour cream ";
                                perfectBurrito = "meat tacos";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping += "sour cream ";
                                perfectBurrito = "meat tacos";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                    if (cheese) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping += "cheese ";
                                perfectBurrito = "meat tacos";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping += "cheese ";
                                perfectBurrito = "meat tacos";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping += "cheese ";
                                perfectBurrito = "meat tacos";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                    if (guac) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping += "guacamole ";
                                perfectBurrito = "meat tacos";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping += "guacamole ";
                                perfectBurrito = "meat tacos";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping += "guacamole ";
                                perfectBurrito = "meat tacos";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                    if (!guac && !cheese && !sourcream && !salsa) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping = "no toppings";
                                perfectBurrito = "meat tacos";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping = "no toppings";
                                perfectBurrito = "meat tacos";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping = "no toppings";
                                perfectBurrito = "meat tacos";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                }
            } else {
                //Burrito with Veggies
                if (foodType_id == R.id.radioButton) {
                    imageSet.setImageResource(R.drawable.burrito);
                    if (salsa) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping = "salsa ";
                                perfectBurrito = "veggie burrito";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping = "salsa ";
                                perfectBurrito = "veggie burrito";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping = "salsa ";
                                perfectBurrito = "veggie burrito";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                    if (sourcream) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping += "sour cream ";
                                perfectBurrito = "veggie burrito";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping += "sour cream ";
                                perfectBurrito = "veggie burrito";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping += "sour cream ";
                                perfectBurrito = "veggie burrito";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                    if (cheese) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping += "cheese ";
                                perfectBurrito = "veggie burrito";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping += "cheese ";
                                perfectBurrito = "veggie burrito";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping += "cheese ";
                                perfectBurrito = "veggie burrito";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                    if (guac) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping += "guacamole ";
                                perfectBurrito = "veggie burrito";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping += "guacamole ";
                                perfectBurrito = "veggie burrito";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping += "guacamole ";
                                perfectBurrito = "veggie burrito";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                    if (!guac && !cheese && !sourcream && !salsa) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping = "no toppings";
                                perfectBurrito = "veggie burrito";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping = "no toppings";
                                perfectBurrito = "veggie burrito";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping = "no toppings";
                                perfectBurrito = "veggie burrito";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                } else {
                    imageSet.setImageResource(R.drawable.taco);
                    if (salsa) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping = "salsa ";
                                perfectBurrito = "veggie tacos";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping = "salsa ";
                                perfectBurrito = "veggie tacos";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping = "salsa ";
                                perfectBurrito = "veggie tacos";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                    if (sourcream) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping += "sour cream ";
                                perfectBurrito = "veggie tacos";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping += "sour cream ";
                                perfectBurrito = "veggie tacos";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping += "sour cream ";
                                perfectBurrito = "veggie tacos";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                    if (cheese) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping += "cheese ";
                                perfectBurrito = "veggie tacos";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping += "cheese ";
                                perfectBurrito = "veggie tacos";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping += "cheese ";
                                perfectBurrito = "veggie tacos";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                    if (guac) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping += "guacamole ";
                                perfectBurrito = "veggie tacos";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping += "guacamole ";
                                perfectBurrito = "veggie tacos";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping += "guacamole ";
                                perfectBurrito = "veggie tacos";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                    if (!guac && !cheese && !sourcream && !salsa) {
                        switch (locationType) {
                            case "The Hill":
                                perfectRestaurant = "Illegal Petes";
                                perfectTopping = "no toppings";
                                perfectBurrito = "veggie tacos";
                                break;
                            case "29th Street":
                                perfectRestaurant = "Chipotle";
                                perfectTopping = "no toppings";
                                perfectBurrito = "veggie tacos";
                                break;
                            case "Pearl Street":
                                perfectRestaurant = "Bartaco";
                                perfectTopping = "no toppings";
                                perfectBurrito = "veggie tacos";
                                break;
                            default:
                                perfectBurrito = "Not enough information provided";
                        }
                    }
                }
            }
            message = "You should check out " + perfectRestaurant + " to get your " + perfectBurrito + " with " + perfectTopping;
            suggestedrest.setText(message);
        }
    }
    private void foundBurritoPlace(View view) {
        Integer locationSet = location.getSelectedItemPosition();
        myBurritoShop.setBurritoShopName(locationSet);
        String suggestedBurritoShop = myBurritoShop.getBurritoShopName();
        String suggestedBurritoURL = myBurritoShop.getBurritoShopURL();

        Intent intent = new Intent(this, BurritoActivity.class);
        intent.putExtra("burritoShopName", suggestedBurritoShop);
        intent.putExtra("burritoShopURL", suggestedBurritoURL);
        startActivity(intent);
    }
}
