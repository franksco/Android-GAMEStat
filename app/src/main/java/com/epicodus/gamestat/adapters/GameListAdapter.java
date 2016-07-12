package com.epicodus.gamestat.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.gamestat.R;
import com.epicodus.gamestat.model.Game;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.GameViewHolder> {
        private ArrayList<Game> mGames = new ArrayList<>();
        private Context mContext;

        public GameListAdapter(Context context, ArrayList<Game> games) {
            mContext = context;
            mGames = games;
        }

    @Override
    public GameListAdapter.GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_list_item, parent, false);
        GameViewHolder viewHolder = new GameViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GameViewHolder holder, int position) {
        holder.bindGame(mGames.get(position));
    }

    @Override
    public int getItemCount() {
        return mGames.size();
    }

    public class GameViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.gameImageView) ImageView mGameImageView;
        @Bind(R.id.gameNameTextView) TextView mGameNameTextView;
        @Bind(R.id.descriptionTextView) TextView mDescriptionTextView;

        private Context mContext;

        public GameViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindGame(Game game) {
            mGameNameTextView.setText(game.getName());
            mDescriptionTextView.setText(game.getDeck());
            Picasso.with(mContext).load(game.getImageUrl()).into(mGameImageView);
        }
    }
}
