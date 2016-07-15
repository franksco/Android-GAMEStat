package com.epicodus.gamestat.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.gamestat.Constants;
import com.epicodus.gamestat.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

//    private DatabaseReference mSearchedGameReference;

    @Bind(R.id.findAllGamesButton) Button mfindAllGamesButton;
    @Bind(R.id.findOneGameButton) Button mfindOneGameButton;
    @Bind(R.id.gameTitleEditText) EditText mGameTitleEditText;
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;
    @Bind(R.id.savedGamesButton) Button mSavedGamesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        mSearchedGameReference = FirebaseDatabase
//                .getInstance()
//                .getReference()
//                .child(Constants.FIREBASE_CHILD_SEARCHED_GAME);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mfindAllGamesButton.setOnClickListener(this);
        mfindOneGameButton.setOnClickListener(this);
        mSavedGamesButton.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if(v == mfindAllGamesButton) {
            Intent intent = new Intent(MainActivity.this, AllSearchActivity.class);
            startActivity(intent);
        }

        if(v == mfindOneGameButton) {
            String gameTitle = mGameTitleEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, GameSearchActivity.class);
            intent.putExtra("gameTitle", gameTitle);
            startActivity(intent);
        }

        if(v == mSavedGamesButton) {
            Intent intent = new Intent(MainActivity.this, SavedGameListActivity.class);
            startActivity(intent);
        }

    }

//    public void saveGameToFirebase(String gameTitle) {
//        mSearchedGameReference.setValue(gameTitle);
//    }
}
