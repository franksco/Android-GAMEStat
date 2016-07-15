package com.epicodus.gamestat.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.gamestat.Constants;
import com.epicodus.gamestat.R;
import com.epicodus.gamestat.adapters.GameListAdapter;
import com.epicodus.gamestat.model.Developer;
import com.epicodus.gamestat.model.Game;
import com.epicodus.gamestat.services.GiantBombService;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class TitleSpecificActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.imageView) ImageView mImageView;
    @Bind(R.id.gameTextView) TextView mGameTextView;
    @Bind(R.id.deckTextView) TextView mdeckTextView;
    @Bind(R.id.genreTextView) TextView mGenreTextView;
    @Bind(R.id.releaseDateTextView) TextView mReleaseDateTextView;
    @Bind(R.id.developersTextView) TextView mDevelopersTextView;
    @Bind(R.id.saveGameButton) TextView saveGameButton;

    private Game mGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_specific);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        ButterKnife.bind(this);
        getGame(id);

        mDevelopersTextView.setOnClickListener(this);
        saveGameButton.setOnClickListener(this);
    }

    private void getGame(String id) {
        final GiantBombService giantBombService = new GiantBombService();
        giantBombService.findOneGame(id, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response){
                mGame = giantBombService.GamePageResults(response);

                TitleSpecificActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        Picasso.with(TitleSpecificActivity.this).load(mGame.getImageUrl()).into(mImageView);
                        mGameTextView.setText(mGame.getName());
                        mdeckTextView.setText(mGame.getDeck());
                        mGenreTextView.setText(mGame.getGenre());
                        mReleaseDateTextView.setText(mGame.getReleaseDate());
                        mDevelopersTextView.setText(mGame.getDevelopers().get(0).getName());

                    }
                });
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == mDevelopersTextView) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mGame.getDevelopers().get(0).getWebsite()));
            startActivity(webIntent);
        }

        if (v == saveGameButton) {
            DatabaseReference gameRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_GAMES);
            gameRef.push().setValue(mGame);
            Toast.makeText(TitleSpecificActivity.this, "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}
