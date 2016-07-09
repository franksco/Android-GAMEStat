package com.epicodus.gamestat.ui;

import okhttp3.Call;
import okhttp3.Callback;
import java.io.IOException;
import java.util.ArrayList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.gamestat.R;
import com.epicodus.gamestat.model.Game;
import com.epicodus.gamestat.services.GiantBombService;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Response;

public class AllSearchActivity extends AppCompatActivity {
    public static final String TAG = AllSearchActivity.class.getSimpleName();

    @Bind(R.id.allGameTextView)
    TextView mAllGameTextView;
    @Bind(R.id.listView)
    ListView mListView;

    public ArrayList<Game> mGames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_search);
        ButterKnife.bind(this);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String allGames = ((TextView) view).getText().toString();
                Toast.makeText(AllSearchActivity.this, allGames, Toast.LENGTH_SHORT).show();
            }
        });
        getAllGames();
    }

    private void getAllGames() {
        final GiantBombService giantBombService = new GiantBombService();

        GiantBombService.findAllGames(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mGames = giantBombService.AllGameResults(response);

                AllSearchActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String[] gameNames = new String[mGames.size()];
                        for (int i = 0; i < gameNames.length; i++) {
                            gameNames[i] = mGames.get(i).getName();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(AllSearchActivity.this,
                                android.R.layout.simple_list_item_1, gameNames);
                        mListView.setAdapter(adapter);

                        for (Game game : mGames) {
                            Log.d(TAG, "Name: " + game.getName());
                            Log.d(TAG, "Deck: " + game.getDeck());
                            Log.d(TAG, "Id: " + game.getId());
                            Log.d(TAG, "Image url: " + game.getImageUrl());
                        }
                    }
                });
            }
        });
    }
}