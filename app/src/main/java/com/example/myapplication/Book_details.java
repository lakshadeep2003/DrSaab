package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.binary.Base64;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.google.gson.Gson;
//import com.phonepe.intent.sdk.api.PhonePe;

import java.util.HashMap;


public class Book_details extends AppCompatActivity{
    Button Pay;
    TextView Pat_Name,Pat_Phone,Pat_Date;
//    FirebaseDatabase database;
//    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        Pay = findViewById(R.id.btnpay);
        Pat_Name = findViewById(R.id.input_pat);
        Pat_Phone = findViewById(R.id.input_no);
//        Pat_Date = findViewById(R.id.input_date);
        showUserData();
//        PhonePe.init(this);
        Pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String pat_name = Pat_Name.getText().toString();
//                String pat_phone = Pat_Phone.getText().toString();
                Intent intent = new Intent(Book_details.this, Language.class);
                startActivity(intent);
//                HashMap<String, Object> data = new HashMap();
//                data.put("merchantTransactionId","txnId");		//String. Mandatory
//                data.put("merchantId", "");				//String. Mandatory
//                data.put("merchantUserId", "u123");				//String. Conditional
//// merchantUserId - Mandatory if paymentInstrument.type is: PAY_PAGE, CARD, SAVED_CARD, TOKEN.
//// merchantUserId - Optional if paymentInstrument.type is: UPI_INTENT, UPI_COLLECT, UPI_QR.
//                data.put("amount",20);							//Long. Mandatory
//                data.put("mobileNumber","");			//String. Optional
//                data.put("callbackUrl","");	//String. Mandatory
            }
        });
    }
    public void showUserData(){
//        database = FirebaseDatabase.getInstance();
//        reference = database.getReference("Patients");
        Intent intent = getIntent();

//        String namePat = intent.getStringExtra("username");
        String phonePat = intent.getStringExtra("phone");
//        String datePat = intent.getStringExtra("date");

//        Pat_Name.setText(namePat);
        Pat_Phone.setText(phonePat);
//        Pat_Date.setText(datePat);
    }
}