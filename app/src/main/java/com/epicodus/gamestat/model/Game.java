package com.epicodus.gamestat.model;


import java.util.ArrayList;
import java.util.List;

public class Game {
    String name;
    String deck;
    String id;
    String genre;
    String imageUrl;
    String releaseDate;
    List<Developer> developers = new ArrayList<>();

    public Game(String name, String deck, String id, String imageUrl) {
        this.name = name;
        this.deck = deck;
        this.id = id;
        this.imageUrl = imageUrl;
    }

    public Game(String name, String deck, String id, String genre, String imageUrl) {
        this.name = name;
        this.deck = deck;
        this.id = id;
        this.genre = genre;
        this.imageUrl = imageUrl;
    }

    public Game(String name, String deck, String id, String genre, String imageUrl, String releaseDate, ArrayList<Developer> developers) {
           this.name = name;
           this.deck = deck;
           this.id = id;
           this.genre = genre;
           this.imageUrl = imageUrl;
           this.releaseDate = releaseDate;
           this.developers = developers;
        }

    public Game() {
    }

    public String getName() {
            return name;
        }

        public String getDeck() {
            return deck;
        }

        public String getId() {
            return id;
        }

        public String getGenre() {
            return genre;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public List<Developer> getDevelopers() {
            return developers;
        }

}
