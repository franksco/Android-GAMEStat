package com.epicodus.gamestat.model;


import java.util.ArrayList;

public class Game {
    private String mName;
    private String mDeck;
    private String mId;
    private String mGenre;
    private String mImageUrl;
    private String mReleaseDate;
    private ArrayList<Developer> mDevelopers = new ArrayList<>();

    public Game(String name, String deck, String id, String imageUrl) {
        this.mName = name;
        this.mDeck = deck;
        this.mId = id;
        this.mImageUrl = imageUrl;
    }

    public Game(String name, String deck, String id, String genre, String imageUrl) {
        this.mName = name;
        this.mDeck = deck;
        this.mId = id;
        this.mGenre = genre;
        this.mImageUrl = imageUrl;
    }

    public Game(String name, String deck, String id, String genre, String imageUrl, String releaseDate, ArrayList<Developer> developers) {
           this.mName = name;
           this.mDeck = deck;
           this.mId = id;
           this.mGenre = genre;
           this.mImageUrl = imageUrl;
           this.mReleaseDate = releaseDate;
           this.mDevelopers = developers;
        }

        public String getName() {
            return mName;
        }

        public String getDeck() {
            return mDeck;
        }

        public String getId() {
            return mId;
        }

        public String getGenre() {
            return mGenre;
        }

        public String getImageUrl() {
            return mImageUrl;
        }

        public String getReleaseDate() {
            return mReleaseDate;
        }

        public ArrayList<Developer> getDevelopers() {
            return mDevelopers;
        }

}
