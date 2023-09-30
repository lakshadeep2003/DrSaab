package com.example.myapplication;

import static java.lang.Math.log;
import static java.lang.Math.max;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;

import org.checkerframework.checker.units.qual.C;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Book extends AppCompatActivity {

    TextView Date,Time,Check;
//    boolean SUNDAY = false;
    Button Submit;
    int year,month,day;

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
        recyclerView = findViewById(R.id.recycler_view);
        linearLayout = findViewById(R.id.time_layout);
        Submit = findViewById(R.id.submit);

        String[] section = getResources().getStringArray(R.array.section);
        ArrayList<String> sectionList = new ArrayList<>(Arrays.asList(section));

        String[] Dr_Time = getResources().getStringArray(R.array.Dr_time);
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(Dr_Time));

//        arrayList.add("09:00 AM");
//        arrayList.add("10:00 AM");
//        arrayList.add("11:00 AM");
//        arrayList.add("12:00 PM");
//        arrayList.add("01:00 PM");
//        arrayList.add("02:00 PM");
//        arrayList.add("03:00 PM");
//        arrayList.add("04:00 PM");
//        arrayList.add("05:00 PM");
//        arrayList.add("06:00 PM");

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
                    year = calendar.get(Calendar.YEAR);
                    month = calendar.get(Calendar.MONTH);
                    day = calendar.get(Calendar.DAY_OF_WEEK);

                    DatePickerDialog datePickerDialog = new DatePickerDialog(Book.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                            if(i2 != Calendar.SUNDAY){
                                Date.setText(i + "/" + i1 + "/" + i2);
                            }
                        }
                    },year, month, day);
                    datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 6));
                    datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 1));
                    datePickerDialog.show();
                }
            });

            Submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!validateBook()) {

                    } else {
                        checkUser();
                    }
//                Intent intent = new Intent(Book.this, Pat_details.class);
//                startActivity(intent);
                }
            });
        }

//    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
//        @Override
//        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//            // Handle the selected date here
//            Toast.makeText(Book.this, "Selected date: " + (monthOfYear + 1) + "/" + dayOfMonth + "/" + year, Toast.LENGTH_SHORT).show();
//        }
//    };

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

