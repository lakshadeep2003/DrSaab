package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

import java.util.Calendar;

public class CustomDatePickerDialog extends DatePickerDialog {
    public CustomDatePickerDialog(Context context, OnDateSetListener listener, int year, int month, int day) {
        super(context, listener, year, month, day);
        updateDate(year, month, day);
        fixDatePicker();
    }

    private void fixDatePicker() {
        // Disable Sundays by setting an OnDateChangedListener
        getDatePicker().init(getDatePicker().getYear(), getDatePicker().getMonth(), getDatePicker().getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(year, monthOfYear, dayOfMonth);

                if (selectedDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    // If it's a Sunday, reset to the last selected date to prevent selection
                    getDatePicker().setMinDate(selectedDate.getTimeInMillis() + (1000 * 60 * 60 * 24));
//                    view.updateDate(getDatePicker().getYear(), getDatePicker().getMonth(), getDatePicker().getDayOfMonth());
                }
            }
        });
    }
}
