package com.epicodus.gamestat.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.gamestat.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TitleSpecificActivity extends AppCompatActivity {
    @Bind(R.id.gameTitleTextView) TextView mGameTitleTextView;
    @Bind(R.id.listView) ListView mListView;
    private String mGameTitle;
    
    private String[] gameInfo = new String[] {"Name: The path", "Release date: of the", "developer: righteous man",
            "publisher: is beset", "Genre: on all sides"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_specific);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, gameInfo);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String gameInfo = ((TextView)view).getText().toString();
                Toast.makeText(TitleSpecificActivity.this, gameInfo, Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent = getIntent();
        mGameTitle = intent.getStringExtra("gameTitle");

    }
}
