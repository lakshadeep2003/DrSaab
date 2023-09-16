package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


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
        Item elonmusk = new Item("Karan",R.drawable.dr,"Skin"," Dr Fee Rs. 500/-"," Booking Rs. 1/-");
        Item jobs = new Item("Sam",R.drawable.dr2,"Pshycologist"," Dr Fee Rs. 500/-"," Booking Rs. 1/-");
        Item mark = new Item("jagriti",R.drawable.dr3,"Skin"," Dr Fee Rs. 500/-"," Booking Rs. 1/-");


        itemList.add(elonmusk);
        itemList.add(jobs);
        itemList.add(mark);
        itemList.add(elonmusk);
        itemList.add(jobs);
        itemList.add(mark);
    }

}
