package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements UserGridAdapter.UserGridCallback {
    RecyclerView rvGridC;
    ArrayList<User> listUser;
    UserGridAdapter userGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rvGridC = findViewById(R.id.rvGrid);
        LoadData();
        userGridAdapter = new UserGridAdapter(listUser, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rvGridC.setAdapter(userGridAdapter);
        rvGridC.setLayoutManager(gridLayoutManager);
    }
    @Override
    public void onItemClick(String id) {
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra("userId", id);
        startActivity(i);
    }

    void LoadData() {
        listUser = new ArrayList<>();
        listUser.add(new User("1", "Hoa 1", "hoa_01.png"));
        listUser.add(new User("2", "Hoa 2", "hoa_02.png"));
        listUser.add(new User("3", "Hoa 3", "hoa_03.png"));
        listUser.add(new User("4", "Hoa 4", "hoa_04.png"));
        listUser.add(new User("5", "Hoa 5", "hoa_05.png"));
        listUser.add(new User("6", "Hoa 6", "hoa_06.png"));
        listUser.add(new User("7", "Hoa 7", "hoa_07.png"));
        listUser.add(new User("8", "Hoa 8", "hoa_08.png"));
        listUser.add(new User("9", "Hoa 9", "hoa_09.png"));
        listUser.add(new User("10", "Hoa 10", "hoa_10.png"));

    }
}