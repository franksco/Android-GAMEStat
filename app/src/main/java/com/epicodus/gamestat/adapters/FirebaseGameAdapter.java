package com.epicodus.gamestat.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;

import com.epicodus.gamestat.model.Game;
import com.epicodus.gamestat.ui.TitleSpecificActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Guest on 7/20/16.
 */
public class FirebaseGameAdapter extends FirebaseRecyclerAdapter<Game, FirebaseGameViewHolder>{
    private DatabaseReference mRef;
    private Context mContext;

    private ChildEventListener mChildEventListener;
    private ArrayList<Game> mGames = new ArrayList<>();

    public FirebaseGameAdapter(Class<Game> modelClass, int modelLayout, Class<FirebaseGameViewHolder> viewHolderClass, Query ref, Context context) {

        super(modelClass, modelLayout, viewHolderClass, ref);
        mRef = ref.getRef();
        mContext = context;

        mChildEventListener = mRef.addChildEventListener((new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mGames.add(dataSnapshot.getValue(Game.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        }));
    }

    @Override
    protected void populateViewHolder(final FirebaseGameViewHolder viewHolder, Game model, int position) {
        viewHolder.bindGame(model);


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TitleSpecificActivity.class);
                intent.putExtra("id", mGames.get(viewHolder.getAdapterPosition()).getId());

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public void cleanup() {
        super.cleanup();
        mGames.clear();
        mRef.removeEventListener(mChildEventListener);
    }
}
