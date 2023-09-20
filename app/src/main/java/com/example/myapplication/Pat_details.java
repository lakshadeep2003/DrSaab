package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pat_details extends AppCompatActivity {
    Button sub_pat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pat_details);
        sub_pat = findViewById(R.id.btnSubmit);

        sub_pat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pat_details.this, Otp.class);
                startActivity(intent);
            }
        });
    }
}