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
                JSONArray gamesJSON = giantBombJSON.getJSONArray("businesses");
                for (int i = 0; i < gamesJSON.length(); i++) {
                    JSONObject gameJSON = gamesJSON.getJSONObject(i);
                    String name = gameJSON.getString("name");
                    String imageUrl = gameJSON.getString("image_url");
                    String id = Integer.toString(gameJSON.getString("id"));
                    Game game = new Game(name, imageUrl, id, "game");

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
                JSONArray gamesJSON = giantBombJSON.getJSONArray("businesses");
                for (int i = 0; i < gamesJSON.length(); i++) {
                    JSONObject gameJSON = gamesJSON.getJSONObject(i);
                    String name = gameJSON.getString("name");
                    String imageUrl = gameJSON.getString("image_url");
                    String id = Integer.toString(gameJSON.getInt("id"));
                    String genre = gameJSON.getString("genre");
                    Game game = new Game(name, imageUrl, id, genre, "game");

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
}
