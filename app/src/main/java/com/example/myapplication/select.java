package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class select extends AppCompatActivity {
    Spinner s2;
    Button select_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        s2 = findViewById(R.id.spinner);
        select_btn = findViewById(R.id.btnselect);

        String [] station = getResources().getStringArray(R.array.station);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(select.this, android.R.layout.simple_spinner_item,station);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter);

        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(select.this,value,Toast.LENGTH_SHORT).show();
                select_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (adapterView.getItemAtPosition(i).equals(station[0])){
                            Intent intent = new Intent(select.this, Spinner2.class);
                            startActivity(intent);
                        }else if (adapterView.getItemAtPosition(i).equals(station[1])){
                            Intent intent = new Intent(select.this, Spinner3.class);
                            startActivity(intent);
                        }else if (adapterView.getItemAtPosition(i).equals(station[2])){
                            Intent intent = new Intent(select.this, Spinner4.class);
                            startActivity(intent);
                        }else {
                            Intent intent = new Intent(select.this, AndroidCardview.class);
                            startActivity(intent);
                        }
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}