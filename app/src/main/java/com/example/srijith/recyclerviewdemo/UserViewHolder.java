package com.example.srijith.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Srijith on 08-10-2017.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {

    ImageView userAvatar;
    TextView username;
    ImageView reorderView;

    public UserViewHolder(View itemView) {
        super(itemView);

        userAvatar = itemView.findViewById(R.id.imageview_profile);
        username = itemView.findViewById(R.id.textview_name);
        reorderView = itemView.findViewById(R.id.imageview_reorder);
    }
}
