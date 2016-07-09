package com.epicodus.gamestat.model;


import java.util.ArrayList;

public class Developer {
    private String mName;
    private String mDeck;
    private String mFounded;
    private String mId;
    private String mWebsite;

    private String mCountry;
    private String mCity;

    public Developer(String name, String id, String website) {
        this.mName = name;
        this.mId = id;
        this.mWebsite = website;
    }


    public String getName() {
        return mName;
    }

    public String getDeck() {
        return mDeck;
    }

    public String getFounded() {
        return mFounded;
    }

    public String getId() {
        return mId;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public String getCountry() {
        return mCountry;
    }

    public String getCity() {
        return mCity;
    }

}

//    private ArrayList<DevelopedGames> mDevelopedGames = new ArrayList<>();
//
//    public ArrayList<DevelopedGames> getDevelopedGames() {
//        return mDevelopedGames;
//    }
//
//    public Developer(String name, String deck, String founded, String id, String website, ArrayList<DevelopedGames> developedgames, String country, String city) {
//        this.mName = name;
//        this.mDeck = deck;
//        this.mFounded = founded;
//        this.mId = id;
//        this.mWebsite = website;
//        this.mDevelopedGames = developedgames;
//        this.mCountry = country;
//        this.mCity = city;
//    }
