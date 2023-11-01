package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Item_slot extends AppCompatActivity {
    TextView Time_slot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_slot);
        Time_slot = findViewById(R.id.text_view);

        Time_slot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateBook()) {

                }else {
                    checkUser();
                }
            }
        });
    }
    public void checkUser(){
        Intent intent = new Intent(Item_slot.this, Pat_details.class);
        startActivity(intent);
    }
    public Boolean validateBook(){
        String Time_layout = Time_slot.getText().toString();
        if (Time_layout.isEmpty()) {
//           Time_layout.setError("Please Check Date and Time");
        } else {
            return true;
        }
        return false;
    }
}
