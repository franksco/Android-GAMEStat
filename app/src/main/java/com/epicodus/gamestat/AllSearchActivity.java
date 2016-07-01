package com.epicodus.gamestat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AllSearchActivity extends AppCompatActivity {
    @Bind(R.id.allGameTextView) TextView mAllGameTextView;
    @Bind(R.id.listView) ListView mListView;

    private String[] gameList = new String[] {"The path of", "the righteous man",
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

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, gameList);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String gameList = ((TextView)view).getText().toString();
                Toast.makeText(AllSearchActivity.this, gameList, Toast.LENGTH_SHORT).show();

            }
        });



    }
}