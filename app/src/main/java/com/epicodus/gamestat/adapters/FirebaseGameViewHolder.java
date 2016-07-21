package com.epicodus.gamestat.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.gamestat.Constants;
import com.epicodus.gamestat.R;
import com.epicodus.gamestat.model.Game;
import com.epicodus.gamestat.ui.TitleSpecificActivity;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FirebaseGameViewHolder extends RecyclerView.ViewHolder{
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;


    View mView;
    Context mContext;
    public ImageView mGameImageView;

    public FirebaseGameViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindGame(Game game) {
        mGameImageView = (ImageView) mView.findViewById(R.id.gameImageView);
        TextView gameNameTextView = (TextView) mView.findViewById(R.id.gameNameTextView);
        TextView descriptionTextView = (TextView) mView.findViewById(R.id.descriptionTextView);

        Picasso.with(mContext)
                .load(game.getImageUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mGameImageView);

        gameNameTextView.setText(game.getName());
        descriptionTextView.setText(game.getDeck());

    }

//    @Override
//    public void onClick(View view) {
//        final List<Game> games = new ArrayList<>();
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_GAMES);
//        mChildEventListener = ref.addChildEventListener((new ChildEventListener() {
//
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                games.add(dataSnapshot.getValue(Game.class));
//
//                int itemPosition = getLayoutPosition();
//                Gson gson = new Gson();
//                String json = gson.toJson(games.get(itemPosition));
//                Log.d("onDataChange: " ,json);
//
////                Intent intent = new Intent(mContext, TitleSpecificActivity.class);
////                intent.putExtra("id", games.get(itemPosition).getId());
////
////
////                mContext.startActivity(intent);
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        }));
////        ref.addListenerForSingleValueEvent(new ValueEventListener() {
////
////            @Override
////            public void onDataChange(DataSnapshot dataSnapshot) {
////
////                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
////                    Log.d("onDataChange: " ,snapshot.getValue()+"");
////                    games.add(snapshot.getValue(Game.class));
////                }
////
////                int itemPosition = getLayoutPosition();
////                Gson gson = new Gson();
////                String json = gson.toJson(games.get(itemPosition));
////                Log.d("onDataChange: " ,json);
////
////                Intent intent = new Intent(mContext, TitleSpecificActivity.class);
////                intent.putExtra("id", games.get(itemPosition).getId());
////
////
////                mContext.startActivity(intent);
////            }
////
////            @Override
////            public void onCancelled(DatabaseError databaseError) {
////            }
////        });

}
