package com.epicodus.gamestat;

import com.epicodus.gamestat.BuildConfig;

public class Constants {
    public static final String API_KEY = BuildConfig.API_KEY;
    public static final String API_GAMES_URL = "http://www.giantbomb.com/api/games";
    public static final String API_BASE_URL = "http://www.giantbomb.com/api/search";
    public static final String API_GAME_URL = "http://www.giantbomb.com/api/game/";
    public static final String API_KEY_QUERY_PARAMETER = "api_key";
    public static final String YOUR_QUERY_PARAMETER = "query"; //Example: "location"
    public static final String FORMAT_PARAMETER = "format";
    public static final String LIMIT_PARAMETER = "limit";
    public static final String FORMAT_PARAMETER_ANSWER = "json";
    public static final String FIELD_LIST_PARAMETER = "field_list";
    public static final String SEARCH_GAME_FIELD_LIST = "genres,name,deck,id,image";
    public static final String ALL_GAMES_FIELD_LIST = "name,deck,id,image";
    public static final String GAME_FIELD_LIST = "genres,name,deck,id,developers,image,original_release_date";
    public static final String FIREBASE_CHILD_GAMES = "savedGames";

}
