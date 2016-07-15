package com.epicodus.gamestat.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.gamestat.Constants;
import com.epicodus.gamestat.R;
import com.epicodus.gamestat.model.Game;
import com.epicodus.gamestat.ui.TitleSpecificActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FirebaseGameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;


    View mView;
    Context mContext;

    public FirebaseGameViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindGame(Game game) {
        ImageView gameImageView = (ImageView) mView.findViewById(R.id.gameImageView);
        TextView gameNameTextView = (TextView) mView.findViewById(R.id.gameNameTextView);
        TextView descriptionTextView = (TextView) mView.findViewById(R.id.descriptionTextView);

        Picasso.with(mContext)
                .load(game.getImageUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(gameImageView);

        gameNameTextView.setText(game.getName());
        descriptionTextView.setText(game.getDeck());

    }

    @Override
    public void onClick(View view) {
        final ArrayList<Game> games = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_GAMES);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    games.add(snapshot.getValue(Game.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, TitleSpecificActivity.class);
                intent.putExtra("id", games.get(itemPosition).getId());


                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
