package com.epicodus.gamestat;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Callback;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GiantBombService {
    public static void findAllGames(Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_GAMES_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.FORMAT_PARAMETER, Constants.FORMAT_PARAMETER_ANSWER)
                .addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_KEY)
                .addQueryParameter(Constants.FIELD_LIST_PARAMETER, Constants.ALL_GAMES_FIELD_LIST);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static void findGames(String query, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.FORMAT_PARAMETER, Constants.FORMAT_PARAMETER_ANSWER)
                .addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_KEY)
                .addQueryParameter(Constants.FIELD_LIST_PARAMETER, Constants.SEARCH_GAME_FIELD_LIST)
                .addQueryParameter(Constants.YOUR_QUERY_PARAMETER, query);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static void findOneGame(String id, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_GAME_URL + id).newBuilder();
        urlBuilder.addQueryParameter(Constants.FORMAT_PARAMETER, Constants.FORMAT_PARAMETER_ANSWER)
                .addQueryParameter(Constants.FIELD_LIST_PARAMETER, Constants.GAME_FIELD_LIST)
                .addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_KEY);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Game> AllGameResults(Response response) {
        ArrayList<Game> games = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject giantBombJSON = new JSONObject(jsonData);
                JSONArray gamesJSON = giantBombJSON.getJSONArray("games");
                for (int i = 0; i < gamesJSON.length(); i++) {
                    JSONObject gameJSON = gamesJSON.getJSONObject(i);
                    String name = gameJSON.getString("name");
                    String deck = gameJSON.getString("deck");
                    String id = Integer.toString(gameJSON.getInt("id"));
                    String imageUrl = gameJSON.getString("image_url");

                    Game game = new Game(name, deck, id, imageUrl);

                    games.add(game);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return games;
    }

    public ArrayList<Game> SearchedGameResults(Response response) {
        ArrayList<Game> games = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject giantBombJSON = new JSONObject(jsonData);
                JSONArray gamesJSON = giantBombJSON.getJSONArray("games");
                for (int i = 0; i < gamesJSON.length(); i++) {
                    JSONObject gameJSON = gamesJSON.getJSONObject(i);
                    String name = gameJSON.getString("name");
                    String deck = gameJSON.getString("deck");
                    String id = Integer.toString(gameJSON.getInt("id"));
                    String genre = gameJSON.getJSONArray("genres").getJSONObject(0).getString("name");
                    String imageUrl = gameJSON.getString("image_url");

                    Game game = new Game(name, deck, id, genre, imageUrl);

                    games.add(game);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return games;
    }

    public Game GamePageResults(Response response) {
        Game game = null;
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject giantBombJSON = new JSONObject(jsonData);
                JSONObject gameJSON = giantBombJSON.getJSONObject("results");
                String name = gameJSON.getString("name");
                String deck = gameJSON.getString("deck");
                String imageUrl = gameJSON.getString("image_url");
                String id = Integer.toString(gameJSON.getInt("id"));
                String genre = gameJSON.getJSONArray("genres").getJSONObject(0).getString("name");
                String ReleaseDate = gameJSON.getString("original_release_rate");

                ArrayList<Developer> Developers = new ArrayList<>();
                JSONArray developersJSON = gameJSON.getJSONArray("developers");
                for (int y = 0; y < developersJSON.length(); y++) {
                    JSONObject developerJSON = developersJSON.getJSONObject(y);
                    String developerSiteDetail = developerJSON.getString("site_detail_url");
                    String developerId = Integer.toString(developerJSON.getInt("id"));
                    String devName = developerJSON.getString("name");

                    Developers.add(new Developer(devName, developerId, developerSiteDetail));
                }

                 game = new Game(name, deck, id, genre, imageUrl,  ReleaseDate, Developers);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return game;
    }
}
