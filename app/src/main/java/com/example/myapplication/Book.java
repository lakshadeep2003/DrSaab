package com.example.myapplication;

import static com.google.android.gms.common.api.internal.BackgroundDetector.initialize;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class Book extends AppCompatActivity {
    TextView Date,Time,Check;
    Button Submit;
    RecyclerView recyclerView;
    LinearLayout linearLayout;
    HashMap<String,ArrayList<String>> itemList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Date = findViewById(R.id.date);
        Check = findViewById(R.id.check);
        Time = findViewById(R.id.schedule_time);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
        long minDate = calendar.getTimeInMillis();
        recyclerView = findViewById(R.id.recycler_view);
        linearLayout = findViewById(R.id.time_layout);
        Submit = findViewById(R.id.submit);

        String[] section = getResources().getStringArray(R.array.section);
        ArrayList<String> sectionList = new ArrayList<>(Arrays.asList(section));

        String[] Dr_Time = getResources().getStringArray(R.array.Dr_time);
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(Dr_Time));

        itemList.put(sectionList.get(0), arrayList);

        BookAdapter adapter = new BookAdapter(this, sectionList, itemList);

        GridLayoutManager manager = new GridLayoutManager(this, 3);

        recyclerView.setLayoutManager(manager);

        adapter.setLayoutManager(manager);

        adapter.shouldShowHeadersForEmptySections(false);

        recyclerView.setAdapter(adapter);

            Date.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Calendar currentDate = Calendar.getInstance();
//                    int year = currentDate.get(Calendar.YEAR);
//                    int month = currentDate.get(Calendar.MONTH);
//                    int day = currentDate.get(Calendar.DAY_OF_MONTH);
//
//                    DatePickerDialog datePickerDialog = new DatePickerDialog(Book.this, new DatePickerDialog.OnDateSetListener() {
//                        @Override
//                        public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay){
//                            Calendar selectedDate = Calendar.getInstance();
//                            selectedDate.set(selectedYear, selectedMonth, selectedDay);
//
//                            if (selectedDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
//                                // If it's a Sunday, show an error message
//                                Toast.makeText(Book.this, "Sundays are disabled.", Toast.LENGTH_SHORT).show();
//                            } else {
//                                // Handle the selected date
//                                Date.setText((selectedMonth + 1) + "/" + selectedDay + "/" + selectedYear);
//                            }
//                        }
//                    }, year, month, day);
//                    datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis() + (1000 * 60 * 60 * 24));
//                    datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis() + (1000 * 60 * 60 * 24 * 6));
//                    datePickerDialog.show();

                    showCustomDatePickerDialog();
//                    year = calendar.get(Calendar.YEAR);
//                    month = calendar.get(Calendar.MONTH);
//                    day = calendar.get(Calendar.DAY_OF_WEEK);
//
//                    DatePickerDialog datePickerDialog = new DatePickerDialog(Book.this, new DatePickerDialog.OnDateSetListener() {
//                        @Override
//                        public void onDateSet(DatePicker datePicker, int year, int month, int day){
//                           Date.setText(year + "/" + (month+1) + "/" + day);
//                        }
//                    },year, month, day);
//                    datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis() + (1000 * 60 * 60 * 24));
//                    datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis() + (1000 * 60 * 60 * 24 * 6));
//                    datePickerDialog.getDatePicker().setMinDate(minDate);
////                    datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis() + (1000 * 60 * 60 * 24));
////                    datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis() + (1000 * 60 * 60 * 24 * 6));
//                    datePickerDialog.show();
                }
            });



            Submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!validateBook()) {

                    }else {
                        checkUser();
                    }
                }
            });
        }

    private void showCustomDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        CustomDatePickerDialog datePickerDialog = new CustomDatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int selectedYear, int monthOfYear, int dayOfMonth) {
                Date.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + selectedYear);
            }
        }, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis() + (1000 * 60 * 60 * 24));
        datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis() + (1000 * 60 * 60 * 24 * 7));
        datePickerDialog.show();
    }

        public void checkUser(){
            Intent intent = new Intent(Book.this, Pat_details.class);
            startActivity(intent);
        }
        public Boolean validateBook(){
            String Time_Slot = itemList.toString();
            String Calendar = Date.getText().toString();
            String Time_layout = Check.getText().toString();
            if (Calendar.isEmpty() | Time_Slot.isEmpty()) {
                Check.setText("Please Check Date and Time");
            } else {
                return true;
            }
            return false;
        }
    }

