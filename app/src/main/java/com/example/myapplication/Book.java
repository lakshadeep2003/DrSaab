package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Book extends AppCompatActivity{

    TextView Date;
    Button Submit;
    int year,month,day;

    RecyclerView recyclerView;
    ArrayList<String> sectionList = new ArrayList<>();
    HashMap<String,ArrayList<String>> itemList = new HashMap<>();
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Date = findViewById(R.id.date);
        Calendar calendar = Calendar.getInstance();
        recyclerView  = findViewById(R.id.recycler_view);
        Submit = findViewById(R.id.submit);

        sectionList.add("Doctor Available Time:-");

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("09:00 AM");
        arrayList.add("10:00 AM");
        arrayList.add("11:00 AM");
        arrayList.add("12:00 PM");
        arrayList.add("01:00 PM");
        arrayList.add("02:00 PM");
        arrayList.add("03:00 PM");
        arrayList.add("04:00 PM");
        arrayList.add("05:00 PM");
        arrayList.add("06:00 PM");

        itemList.put(sectionList.get(0),arrayList);

        BookAdapter adapter = new BookAdapter(this,sectionList,itemList);

        GridLayoutManager manager = new GridLayoutManager(this,3);

        recyclerView.setLayoutManager(manager);

        adapter.setLayoutManager(manager);

        adapter.shouldShowHeadersForEmptySections(false);

        recyclerView.setAdapter(adapter);



        Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Book.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        Date.setText(i+"/"+i1+"/"+ i2);
                    }
                },year,month,day);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Book.this, Pat_details.class);
                startActivity(intent);
            }
        });
    }
}
