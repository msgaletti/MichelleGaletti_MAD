package com.example.lab8;

import android.widget.TextView;

public class FavHoliday {
    private String holiday;
    private String holidayFoodURL;
    private String holidayPicture;


    private void setHolidayInfo(Integer holidayMovie){
        switch(holidayMovie){
            case 0:
                holiday= "Christmas";
                holidayFoodURL="https://www.food.com/recipe/the-most-wonderful-gingerbread-cookies-80156";
                break;
            case 1:
                holiday="Thanksgiving";
                holidayFoodURL="https://www.thekitchn.com/how-to-make-the-very-best-thanksgiving-stuffing-237564";
                break;
            case 2:
                holiday="Easter";
                holidayFoodURL="https://www.allrecipes.com/recipe/65769/three-cheese-garlic-scalloped-potatoes/";
                break;
            case 3:
                holiday="Halloween";
                holidayFoodURL="https://www.brit.co/halloween-candy-recipes/";
                break;
            case 4:
                holiday="Valentine's Day";
                holidayFoodURL="https://www.bonappetit.com/recipe/classic-chocolate-mousse";
                break;
            case 5:
                holiday="New Year";
                holidayFoodURL="https://www.foodandwine.com/recipes/classic-swiss-cheese-fondue";
                break;
            case 6:
                holiday="July 4th";
                holidayFoodURL="https://www.allrecipes.com/recipe/26819/hot-artichoke-and-spinach-dip-ii/";
                break;
            default:
                holiday="none";
                holidayFoodURL="https://m.wikihow.com/Have-Fun";
        }
    }
    public String getHoliday(){
        return holiday;
    }
    public String getHolidayFoodURL(){
        return holidayFoodURL;
    }
    public void setHoliday(Integer holidayMovie){setHolidayInfo(holidayMovie);}
}
