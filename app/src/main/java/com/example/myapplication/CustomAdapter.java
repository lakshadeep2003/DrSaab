package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by phoenix on 31/8/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Activity mContext;
    private List<Item> itemList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, company,pay,booking;
        public ImageView photo;

        public Button Book_Date;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.name);
            company = (TextView) view.findViewById(R.id.company);
            pay = (TextView) view.findViewById(R.id.pay);
            booking = (TextView) view.findViewById(R.id.booking);
            photo = (ImageView) view.findViewById(R.id.photo);
            Book_Date = (Button) view.findViewById(R.id.book);
        }
    }


    public CustomAdapter(Activity mContext, List<Item> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Item item = itemList.get(position);
        holder.title.setText(item.getName());
        holder.company.setText(item.getCompany());
        holder.pay.setText(item.getPay());
        holder.booking.setText(item.getBooking());

        holder.Book_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Book.class);
                mContext.startActivity(intent);
            }
        });

        // loading photo using Glide library
        Glide.with(mContext).load(item.getPhoto()).into(holder.photo);

        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,item.getName()+" Clicked",Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }
}