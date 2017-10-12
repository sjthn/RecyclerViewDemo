package com.example.srijith.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Srijith on 08-10-2017.
 */

public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements
        View.OnClickListener {
    private static final int USER_TYPE = 1;
    private static final int HEADER_TYPE = 2;
    private List<User> usersList;
    private UserItemCallback itemCallback;

    public UserListAdapter(UserItemCallback itemCallback) {

        this.itemCallback = itemCallback;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case USER_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_user_list_item, parent, false);
                view.setOnClickListener(this);
                return new UserViewHolder(view);
            case HEADER_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_user_list_section_header, parent, false);
                return new SectionHeaderViewHolder(view);
            default:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_user_list_item, parent, false);
                view.setOnClickListener(this);
                return new UserViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == USER_TYPE) {
            ((UserViewHolder) holder).username.setText(usersList.get(position).getName());
            Glide.with(holder.itemView).load(usersList.get(position).getImageUrl()).into(((UserViewHolder) holder).userAvatar);
        } else {
            ((SectionHeaderViewHolder) holder).sectionTitle.setText(usersList.get(position).getType());
        }
    }

    @Override
    public int getItemCount() {
        return usersList == null ? 0 : usersList.size();
    }

    @Override
    public int getItemViewType(int position) {
        int type;
        if (!TextUtils.isEmpty(usersList.get(position).getName())) {
            type = USER_TYPE;
        } else {
            type = HEADER_TYPE;
        }
        return type;
    }

    public void setUserList(List<User> usersList) {
        this.usersList = usersList;
        notifyDataSetChanged();
    }

    public void addNewUser(int position, User newUser) {
        if (usersList != null) {
            usersList.add(position, newUser);
        }
    }

    public void removeUser(int position) {
        if (usersList != null) {
            usersList.remove(position);
        }
    }

    public void changeUser(int position) {
        if (usersList != null) {
            User user = usersList.get(position);
            String username = "Wyatt Fuller";
            String imageUrl = "https://randomuser.me/api/portraits/men/12.jpg";
            usersList.set(position, new User(user.getId(), username, imageUrl, user.getType()));
        }
    }

    @Override
    public void onClick(View v) {
        itemCallback.onUserItemSelected(v);
    }

    public interface UserItemCallback {
        void onUserItemSelected(View v);
    }
}
