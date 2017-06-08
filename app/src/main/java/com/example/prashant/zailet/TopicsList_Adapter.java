package com.example.prashant.zailet;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashant on 8/6/17.
 */

public class TopicsList_Adapter extends RecyclerView.Adapter<TopicsList_Adapter.TopicHolder> {

    private Context mContext;
    private ArrayList<Topic> topicList;


    public class TopicHolder extends RecyclerView.ViewHolder{
        public ImageView coverImageView;
        public TextView titleTextView;

        public TopicHolder(View itemView) {
            super(itemView);
            coverImageView = (ImageView) itemView.findViewById(R.id.coverImageView);
            titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);

        }
    }

    public TopicsList_Adapter(Context mContext, ArrayList<Topic> topicList) {
        this.mContext = mContext;
        this.topicList = topicList;


    }

    @Override
    public TopicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_items, parent, false);
        return new TopicHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TopicHolder holder, int position) {
        Topic topic = topicList.get(position);
        holder.titleTextView.setText(topic.getInterest());

        // loading album cover using Glide library
        Picasso.with(mContext).load("http://zailet.com/"+topic.getCover()).into(holder.coverImageView);

    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }
}
