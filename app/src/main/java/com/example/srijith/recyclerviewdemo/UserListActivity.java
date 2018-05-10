package com.example.srijith.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.List;

public class UserListActivity extends AppCompatActivity {

    private static final String TAG = "UserListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        RecyclerView userRecyclerView = findViewById(R.id.recyclerview_user_list);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        UserListAdapter adapter = new UserListAdapter();
        SwipeAndDragHelper swipeAndDragHelper = new SwipeAndDragHelper(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(swipeAndDragHelper);
        adapter.setTouchHelper(touchHelper);
        userRecyclerView.setAdapter(adapter);
        touchHelper.attachToRecyclerView(userRecyclerView);

        UsersData usersData = new UsersData();
        List<User> usersList = usersData.getUsersList();
        adapter.setUserList(usersList);
    }

}
