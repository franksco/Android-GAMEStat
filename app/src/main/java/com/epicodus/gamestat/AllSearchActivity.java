package com.epicodus.gamestat;

import android.content.Intent;
import okhttp3.Call;
import okhttp3.Callback;
import java.io.IOException;
import java.util.ArrayList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Response;

public class AllSearchActivity extends AppCompatActivity {
    public static final String TAG = AllSearchActivity.class.getSimpleName();

    @Bind(R.id.allGameTextView) TextView mAllGameTextView;
    @Bind(R.id.listView) ListView mListView;

    public ArrayList<Game> mGames = new ArrayList<>();

    private String[] allGames = new String[] {"The path of", "the righteous man",
            "is beset on", "all sides by", "the iniquities of", "the selfish and",
            "the tyranny of", "evil men. Blessed", "is he who,", "in the name",
            "of charity and", "good will, shepherds", "the weak through",
            "the valley of", "darkness, for he", "is truly his", "brother's keeper and", "the finder of",
            "lost children."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_search);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, allGames);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String allGames = ((TextView)view).getText().toString();
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
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                    mGames = giantBombService.AllGameResults(response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}