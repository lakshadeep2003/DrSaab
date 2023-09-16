package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Book extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextView Date;
//    TimePicker Time;
//    private TextView textView;

    RecyclerView recyclerView;
    ArrayList<String> sectionList = new ArrayList<>();
    HashMap<String,ArrayList<String>> itemList = new HashMap<>();
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Date = findViewById(R.id.date);
//        Time = findViewById(R.id.time);
//        textView = findViewById(R.id.text);

        recyclerView  = findViewById(R.id.recycler_view);

        sectionList.add("Doctor Time");

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

//        adapter.setLayoutManager(manager);

        adapter.shouldShowHeadersForEmptySections(false);



        Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

//        Time.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                openDatePicker(); // Open date picker dialog
//
//                openTimePicker(); //Open time picker dialog
//            }
//        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(currentDateString);
    }

//    private void openDatePicker(){
//        DatePickerDialog datePickerDialog = new DatePickerDialog(this, R.style.DialogTheme , new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//
//                //Showing the picked value in the textView
//                textView.setText(String.valueOf(year)+ "."+String.valueOf(month)+ "."+String.valueOf(day));
//
//            }
//        }, 2023, 01, 20);
//
//        datePickerDialog.show();
//    }
//
//
//    private void openTimePicker(){
//
//        TimePickerDialog timePickerDialog = new TimePickerDialog(this, R.style.DialogTheme, new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
//
//
//                //Showing the picked value in the textView
//                textView.setText(String.valueOf(hour)+ ":"+String.valueOf(minute));
//
//            }
//        }, 15, 30, false);
//
//        timePickerDialog.show();
//    }
}
