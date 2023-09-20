package com.example.myapplication;

import android.app.Activity;
import android.graphics.Color;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;


import com.afollestad.sectionedrecyclerview.SectionedRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BookAdapter extends SectionedRecyclerViewAdapter<BookAdapter.ViewHolder>{

    Activity activity;
    ArrayList<String> sectionList;
    HashMap<String,ArrayList<String>> itemList = new HashMap<>();

    int selectedSection = -1;
    int selectedItem = -1;

    public BookAdapter(Activity activity,ArrayList<String> sectionList,
                       HashMap<String,ArrayList<String>> itemList){
        this.activity = activity;
        this.sectionList = sectionList;
        this.itemList = itemList;
        notifyDataSetChanged();
    }
    @Override
    public int getSectionCount() {
        return sectionList.size();
    }

    @Override
    public int getItemCount(int section) {
        return itemList.get(sectionList.get(section)).size();
    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder holder, int section) {
        holder.textView.setText(sectionList.get(section));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int section, int relativePosition, int absolutePosition) {
        String sItem = itemList.get(sectionList.get(section)).get(relativePosition);
        holder.textView.setText(sItem);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,sItem,Toast.LENGTH_SHORT).show();
                selectedSection = section;
                selectedItem = relativePosition;

                notifyDataSetChanged();
            }
        });

        if(selectedSection == section && selectedItem == relativePosition){
            holder.textView.setBackground(ContextCompat.getDrawable(
                    activity,R.drawable.rectangle_fil
            ));

            holder.textView.setTextColor(Color.WHITE);
        }else {
            holder.textView.setBackground(ContextCompat.getDrawable(
                    activity,R.drawable.rectangle_outline
            ));
            holder.textView.setTextColor(Color.BLACK);
        }
    }

    @Override
    public int getItemViewType(int section, int relativePosition, int absolutePosition) {
        if (section == 1) {
            return 0;
        }
        return super.getItemViewType(section, relativePosition, absolutePosition);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout;

        if(viewType == VIEW_TYPE_HEADER){
            layout = R.layout.item_header;
        }else{
            layout = R.layout.item_slot;
        }
        View view = LayoutInflater.from(parent.getContext())
                .inflate(layout,parent,false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_view);
        }
    }
}
