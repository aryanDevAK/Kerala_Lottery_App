package com.example.keralalottery;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ListView listView;
    ArrayList<Lottery> lotteryArrayList;
    private static MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        //Adapter of List
        listView = findViewById(R.id.lotteryListView);

        //Data Source
        lotteryArrayList = new ArrayList<>();

        Lottery lottery1 = new Lottery("10",R.drawable.rupees_10);
        Lottery lottery2 = new Lottery("50",R.drawable.rupees_50);
        Lottery lottery3 = new Lottery("70",R.drawable.rupees_70);
        Lottery lottery4 = new Lottery("80",R.drawable.rupees_80);
        Lottery lottery5 = new Lottery("500",R.drawable.rupees_500);

        lotteryArrayList.add(lottery1);
        lotteryArrayList.add(lottery2);
        lotteryArrayList.add(lottery3);
        lotteryArrayList.add(lottery4);
        lotteryArrayList.add(lottery5);

        //Adapter
        adapter = new MyCustomAdapter(lotteryArrayList,getApplicationContext());
        listView.setAdapter(adapter);
    }
}

