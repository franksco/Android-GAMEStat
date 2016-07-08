package com.epicodus.gamestat;


import java.util.ArrayList;

public class Game {
    private String mName;
    private String mDeck;
    private String mId;
    private String mGenres;
    private String mImageUrl;
    private ArrayList<String> mDevelopers = new ArrayList<>();

    public Game(String name, String deck, String id, String imageUrl) {
        this.mName = name;
        this.mDeck = deck;
        this.mId = id;
        this.mImageUrl = imageUrl;
    }

    public Game(String name, String deck, String id, String genres,
                String imageUrl) {
        this.mName = name;
        this.mDeck = deck;
        this.mId = id;
        this.mGenres = genres;
        this.mImageUrl = imageUrl;
    }

    public Game(String name, String deck, String id, String genres,
                String imageUrl, ArrayList<String> developers) {
           this.mName = name;
           this.mDeck = deck;
           this.mId = id;
           this.mGenres = genres;
           this.mImageUrl = imageUrl;
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

        public String getGenres() {
            return mGenres;
        }

        public String getImageUrl() {
            return mImageUrl;
        }

        public ArrayList<String> getDevelopers() {
            return mDevelopers;
        }

}
