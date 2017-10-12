package com.example.srijith.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

import java.util.List;

public class UserListActivity extends AppCompatActivity implements
        RadioGroup.OnCheckedChangeListener, UserListAdapter.UserItemCallback {

    private static final String TAG = "UserListActivity";

    private static final int ADD_CHECKED = 1;
    private static final int REMOVE_CHECKED = 2;
    private static final int CHANGE_CHECKED = 3;

    private int currentCheckedButton = RadioGroup.NO_ID;

    private RecyclerView userRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        ((RadioGroup) findViewById(R.id.radiogroup_item_animator)).setOnCheckedChangeListener(this);
        userRecyclerView = findViewById(R.id.recyclerview_user_list);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        userRecyclerView.addItemDecoration(new UserListItemDecorator());
        UserListAdapter adapter = new UserListAdapter(this);
        userRecyclerView.setAdapter(adapter);

        UsersData usersData = new UsersData();
        List<User> usersList = usersData.getUsersList();
        adapter.setUserList(usersList);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radiobutton_add_item:
                currentCheckedButton = ADD_CHECKED;
                break;
            case R.id.radiobutton_remove_item:
                currentCheckedButton = REMOVE_CHECKED;
                break;
            case R.id.radiobutton_change_item:
                currentCheckedButton = CHANGE_CHECKED;
                break;
            default:
                currentCheckedButton = RadioGroup.NO_ID;
                break;
        }
    }

    @Override
    public void onUserItemSelected(View v) {
        int position = userRecyclerView.getChildAdapterPosition(v);
        if (position != RecyclerView.NO_POSITION) {
            RecyclerView.ViewHolder viewHolder = userRecyclerView.getChildViewHolder(v);
            if (viewHolder instanceof SectionHeaderViewHolder) {
                return;
            }
            UserListAdapter adapter = (UserListAdapter) userRecyclerView.getAdapter();
            switch (currentCheckedButton) {
                case ADD_CHECKED:
                    addItem(position, adapter);
                    break;
                case REMOVE_CHECKED:
                    removeItem(position, adapter);
                    break;
                case CHANGE_CHECKED:
                    changeItem(position, adapter);
                    break;
            }
        }
    }

    private void changeItem(int position, UserListAdapter adapter) {
        adapter.changeUser(position);
        adapter.notifyItemChanged(position);
    }

    private void removeItem(int position, UserListAdapter adapter) {
        adapter.removeUser(position);
        adapter.notifyItemRemoved(position);
    }

    private void addItem(int position, UserListAdapter adapter) {
        User newUser = new UsersData().getNewUser();
        adapter.addNewUser(position, newUser);
        adapter.notifyItemInserted(position);
    }
}
