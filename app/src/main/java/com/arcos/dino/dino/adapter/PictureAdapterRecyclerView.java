package com.arcos.dino.dino.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arcos.dino.dino.R;

/**
 * Created by Gustavo Arcos on 16/03/2017.
 * clase que mmaneja las listas
 */

public class PictureAdapterRecyclerView {


    //clase anidada que majena los views que componen el elemento dentro del recyclerview
    public class PictureViewHolder extends RecyclerView.ViewHolder{

        private ImageView pictureCard;
        private TextView activityCard;
        private TextView likeCard;
        private TextView numberCard;

        public PictureViewHolder(View itemView) {
            super(itemView);

            pictureCard=(ImageView) itemView.findViewById(R.id.pictureView);
        }
    }

}
