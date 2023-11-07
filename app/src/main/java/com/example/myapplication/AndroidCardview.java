package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class AndroidCardview extends AppCompatActivity {


    ArrayList<Item> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_cardview);

        //init
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        itemList = new ArrayList<>();
        CustomAdapter adapter = new CustomAdapter(this, itemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);

        //Set data
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        //set data to recyclerview
        setData();
    }

    private void setData() {
        String [] Dr1 = getResources().getStringArray(R.array.Dr1);
        String [] Dr2 = getResources().getStringArray(R.array.Dr2);
        String [] Dr3 = getResources().getStringArray(R.array.Dr3);
        Item dr1 = new Item(Dr1[0],R.drawable.dr,Dr1[2],Dr1[3],Dr1[4],Dr1[5]);
        Item dr2 = new Item(Dr2[0],R.drawable.dr2,Dr2[2],Dr2[3],Dr2[4],Dr2[5]);
        Item dr3 = new Item(Dr3[0],R.drawable.dr3,Dr3[2],Dr3[3],Dr3[4],Dr3[5]);

        itemList.add(dr1);
        itemList.add(dr2);
        itemList.add(dr3);
    }

}
