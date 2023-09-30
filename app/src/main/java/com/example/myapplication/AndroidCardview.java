package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AndroidCardview extends AppCompatActivity {

//    FirebaseFirestore db;

    ArrayList<Item> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_cardview);

        //init
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        itemList = new ArrayList<>();
        CustomAdapter adapter = new CustomAdapter(this, itemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);

        //Set data
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        //set data to recyclerview
        setData();

//      db=FirebaseFirestore.getInstance();
//        db.collection("Doctors").get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
//                        for(DocumentSnapshot d:list)
//                        {
//                            Item obj=d.toObject(Item.class);
//                            itemList.add(obj);
//                        }
//                        adapter.notifyDataSetChanged();
//                    }
//                });

//        db.collection("Doctors") // Replace with your Firestore collection name
//                .add(itemList)
//                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DocumentReference> task) {
//                        if (task.isSuccessful()) {
//                            // Data added successfully
//                            DocumentReference documentReference = task.getResult();
//                            String documentId = documentReference.getId();
//                            newItem.setId(documentId); // Set the ID of your item for reference if needed
//                            // Refresh your RecyclerView or update your local data list
//                        } else {
//                            // Handle the error
//                            Exception e = task.getException();
//                            e.printStackTrace();
//                        }
//                    }
//                });

    }

    private void setData() {
        String [] Dr1 = getResources().getStringArray(R.array.Dr1);
        String [] Dr2 = getResources().getStringArray(R.array.Dr1);
        String [] Dr3 = getResources().getStringArray(R.array.Dr1);
        Item elonmusk = new Item(Dr1[0],R.drawable.dr,Dr1[2],Dr1[3],Dr1[4],Dr1[5]);
        Item jobs = new Item(Dr2[0],R.drawable.dr2,Dr2[2],Dr2[3],Dr2[4],Dr2[5]);
        Item mark = new Item(Dr3[0],R.drawable.dr3,Dr3[2],Dr3[3],Dr3[4],Dr3[5]);


        itemList.add(elonmusk);
        itemList.add(jobs);
        itemList.add(mark);
        itemList.add(elonmusk);
        itemList.add(jobs);
        itemList.add(mark);
        itemList.add(elonmusk);
        itemList.add(jobs);
        itemList.add(mark);
        itemList.add(elonmusk);
        itemList.add(jobs);
        itemList.add(mark);
    }

}
