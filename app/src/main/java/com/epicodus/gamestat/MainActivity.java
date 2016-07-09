package com.epicodus.gamestat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.findAllGamesButton) Button mfindAllGamesButton;
    @Bind(R.id.findOneGameButton) Button mfindOneGameButton;
    @Bind(R.id.gameTitleEditText) EditText mGameTitleEditText;
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mfindAllGamesButton.setOnClickListener(this);
        mfindOneGameButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mfindAllGamesButton) {
            Intent intent = new Intent(MainActivity.this, AllSearchActivity.class);
            startActivity(intent);
        }

        if(v == mfindOneGameButton) {
            String gameTitle = mGameTitleEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, TitleSpecificActivity.class);
            intent.putExtra("gameTitle", gameTitle);
            startActivity(intent);
        }
    }
}
