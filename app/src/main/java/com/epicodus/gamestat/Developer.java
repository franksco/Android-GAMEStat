package com.epicodus.gamestat;


import java.util.ArrayList;

public class Developer {
    private String mName;
    private String mDeck;
    private String mId;
    private String mGenres;
    private String mImageUrl;
    private String mReleaseDate;
    private ArrayList<Game> mGames = new ArrayList<>();

    public Developer(String name, String deck, String id, String imageUrl) {
        this.mName = name;
        this.mDeck = deck;
        this.mId = id;
        this.mImageUrl = imageUrl;
    }

    public Developer(String name, String deck, String id, String genres,
                String imageUrl) {
        this.mName = name;
        this.mDeck = deck;
        this.mId = id;
        this.mGenres = genres;
        this.mImageUrl = imageUrl;
    }

    public Developer(String name, String deck, String id, String genres,
                String imageUrl, String releaseDate, ArrayList<Developer> developers) {
        this.mName = name;
        this.mDeck = deck;
        this.mId = id;
        this.mGenres = genres;
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

    public String getGenres() {
        return mGenres;
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

}
