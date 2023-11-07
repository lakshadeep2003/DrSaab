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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;

public class Pat_details extends AppCompatActivity {
    CountryCodePicker countryCodePicker;
    EditText phoneInput,phoneName;
    Button sendOtpBtn;
    ProgressBar progressBar;
    FirebaseDatabase database;
    DatabaseReference reference;

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
            passUserData();
            if(!validateUsername()){

            }else{
                checkUser();
            }
        });
    }

    public void checkUser(){
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Patients");

        String phone = phoneInput.getText().toString();
        String username = phoneName.getText().toString();

        HelperClass helperClass = new HelperClass(username, phone);
        reference.child(username).setValue(helperClass);

        Toast.makeText(Pat_details.this, "Your Phone No Register Successfully", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Pat_details.this, Book_details.class);
        intent.putExtra("phone",countryCodePicker.getFullNumberWithPlus());
        startActivity(intent);
//        Intent intent = new Intent(Pat_details.this,Otp.class);
//        intent.putExtra("phone",countryCodePicker.getFullNumberWithPlus());
//        startActivity(intent);
    }

    public void passUserData(){
        String userUsername = phoneName.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Patients");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    String phoneFromDB = snapshot.child(userUsername).child("phone").getValue(String.class);
                    String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);

                    Intent intent = new Intent(Pat_details.this, Book_details.class);

                    intent.putExtra("phone", phoneFromDB);
                    intent.putExtra("username", usernameFromDB);

                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
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