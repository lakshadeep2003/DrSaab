package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class Pat_details extends AppCompatActivity {
    CountryCodePicker countryCodePicker;
    EditText phoneInput,phoneName;
    Button sendOtpBtn;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pat_details);
        countryCodePicker = findViewById(R.id.login_countrycode);
        phoneInput = findViewById(R.id.login_mobile_number);
        phoneName = findViewById(R.id.inputName);
        sendOtpBtn = findViewById(R.id.send_otp_btn);
        progressBar = findViewById(R.id.login_progress_bar);

        progressBar.setVisibility(View.GONE);

        countryCodePicker.registerCarrierNumberEditText(phoneInput);
        sendOtpBtn.setOnClickListener((v)->{
            if(!validateUsername()){

            }else{
                checkUser();
            }
        });
    }

    public void checkUser(){
        Intent intent = new Intent(Pat_details.this,Otp.class);
        intent.putExtra("phone",countryCodePicker.getFullNumberWithPlus());
        startActivity(intent);
    }
    public Boolean validateUsername(){
        String Name = phoneName.getText().toString();
        String PhoneNo = phoneInput.getText().toString();
        if (Name.isEmpty()) {
            phoneName.setError("Enter your Name");
        }else if (PhoneNo.isEmpty()) {
            phoneInput.setError("Enter your valid Phone Number");
        }else {
            return true;
        }
        return false;
    }
}