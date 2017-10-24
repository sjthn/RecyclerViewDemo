package com.example.srijith.recyclerviewdemo;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Srijith on 08-10-2017.
 */

public class SectionHeaderViewHolder extends RecyclerView.ViewHolder {

    TextView sectionTitle;

    public SectionHeaderViewHolder(View itemView) {
        super(itemView);
        sectionTitle = itemView.findViewById(R.id.textview_section_header);
    }

}
