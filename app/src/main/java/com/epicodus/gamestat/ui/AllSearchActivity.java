package com.epicodus.gamestat.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epicodus.gamestat.R;
import com.epicodus.gamestat.adapters.GameListAdapter;
import com.epicodus.gamestat.model.Game;
import com.epicodus.gamestat.services.GiantBombService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class AllSearchActivity extends AppCompatActivity {
    public static final String TAG = AllSearchActivity.class.getSimpleName();

    @Bind(R.id.allGamelistView) RecyclerView mRecyclerView;

    private GameListAdapter mAdapter;
//    private ProgressDialog mAuthProgressDialog;

    public ArrayList<Game> mGames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_search);
        ButterKnife.bind(this);

//        createAuthProgressDialog();

        getAllGames();
    }

//    private void createAuthProgressDialog() {
//        mAuthProgressDialog = new ProgressDialog(this);
//        mAuthProgressDialog.setTitle("Loading...");
//        mAuthProgressDialog.setMessage("Authenticating with Firebase...");
//        mAuthProgressDialog.setCancelable(false);
//    }

    private void getAllGames() {
        final GiantBombService giantBombService = new GiantBombService();

//        mAuthProgressDialog.show();

        GiantBombService.findAllGames(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mGames = giantBombService.AllGameResults(response);

//                mAuthProgressDialog.dismiss();


                AllSearchActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new GameListAdapter(getApplicationContext(), mGames);

                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(AllSearchActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    
                    }
                });
            }
        });
    }
}