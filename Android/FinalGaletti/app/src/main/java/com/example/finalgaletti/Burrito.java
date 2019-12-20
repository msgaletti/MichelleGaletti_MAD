package com.example.finalgaletti;

public class Burrito {
    private String burritoShopName;
    private String burritoShopURL;

    private void setBurritoInfo(Integer locationInBoulder){
        switch(locationInBoulder){
            case 0: //The Hill
                burritoShopName="Illegal Petes";
                burritoShopURL="http://illegalpetes.com/";
                break;
            case 1: //29th Street
                burritoShopName="Chipotle";
                burritoShopURL="https://www.chipotle.com/";
                break;
            case 2: //Pearl Street
                burritoShopName="Bartaco";
                burritoShopURL="https://bartaco.com/";
                break;
            default:
                burritoShopName="none";
                burritoShopURL="";
                break;
        }
    }

    public String getBurritoShopName(){
        return burritoShopName;
    }

    public String getBurritoShopURL(){
        return burritoShopURL;
    }

    public void setBurritoShopName(Integer locationInBoulder){
        setBurritoInfo(locationInBoulder);
    }
}
