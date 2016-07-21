package com.epicodus.gamestat.model;


public class Developer {
    private String devname;
    private String mDeck;
    private String mFounded;
    private String devid;
    private String devwebsite;

    private String mCountry;
    private String mCity;

    public Developer(String name, String id, String website) {
        this.devname = name;
        this.devid = id;
        this.devwebsite = website;
    }

    public Developer() {}

    public String getDevname() {
        return devname;
    }

    public String getDeck() {
        return mDeck;
    }

    public String getFounded() {
        return mFounded;
    }

    public String getDevid() {
        return devid;
    }

    public String getDevwebsite() {
        return devwebsite;
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
//    public Developer(String devname, String deck, String founded, String devid, String devwebsite, ArrayList<DevelopedGames> developedgames, String country, String city) {
//        this.devname = devname;
//        this.mDeck = deck;
//        this.mFounded = founded;
//        this.devid = devid;
//        this.devwebsite = devwebsite;
//        this.mDevelopedGames = developedgames;
//        this.mCountry = country;
//        this.mCity = city;
//    }
