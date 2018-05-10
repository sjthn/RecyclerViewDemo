package com.example.srijith.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Srijith on 08-10-2017.
 */

public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements
        SwipeAndDragHelper.ActionCompletionContract {
    private static final int USER_TYPE = 1;
    private static final int HEADER_TYPE = 2;
    private List<User> usersList;
    private ItemTouchHelper touchHelper;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case USER_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_user_list_item, parent, false);
                return new UserViewHolder(view);
            case HEADER_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_user_list_section_header, parent, false);
                return new SectionHeaderViewHolder(view);
            default:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_user_list_item, parent, false);
                return new UserViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == USER_TYPE) {
            ((UserViewHolder) holder).username.setText(usersList.get(position).getName());
            Glide.with(holder.itemView).load(usersList.get(position).getImageUrl()).into(((UserViewHolder) holder).userAvatar);
            ((UserViewHolder) holder).reorderView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                        touchHelper.startDrag(holder);
                    }
                    return false;
                }
            });
        } else {
            SectionHeaderViewHolder headerViewHolder = (SectionHeaderViewHolder) holder;
            headerViewHolder.sectionTitle.setText(usersList.get(position).getType());
        }
    }

    @Override
    public int getItemCount() {
        return usersList == null ? 0 : usersList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (TextUtils.isEmpty(usersList.get(position).getName())) {
            return HEADER_TYPE;
        } else {
            return USER_TYPE;
        }
    }

    public void setUserList(List<User> usersList) {
        this.usersList = usersList;
        notifyDataSetChanged();
    }

    @Override
    public void onViewMoved(int oldPosition, int newPosition) {
        User targetUser = usersList.get(oldPosition);
        User user = new User(targetUser);
        usersList.remove(oldPosition);
        usersList.add(newPosition, user);
        notifyItemMoved(oldPosition, newPosition);
    }

    @Override
    public void onViewSwiped(int position) {
        usersList.remove(position);
        notifyItemRemoved(position);
    }

    public void setTouchHelper(ItemTouchHelper touchHelper) {

        this.touchHelper = touchHelper;
    }
}
