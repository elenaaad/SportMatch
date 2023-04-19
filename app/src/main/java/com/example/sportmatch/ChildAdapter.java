package com.example.sportmatch;

import android.content.Context;
import android.location.Geocoder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder> {

    ArrayList<Event> eventList;
    Context context;

    public ChildAdapter(ArrayList<Event> eventList, Context context) {
        this.eventList= eventList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChildViewHolder( LayoutInflater.from(context).inflate(R.layout.category_row_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChildAdapter.ChildViewHolder holder, int position) {
//        holder.itemImage.setImageResource(eventList.get(position).getImage());
//        Glide.with(context).load(eventList.get(position).getDa)
        holder.itemImage.setImageResource(R.drawable.p11);

        String nbrPart=eventList.get(position).getNrPlayers();
        String numberOnly = nbrPart.replaceAll("[^0-9]", "");
        int result = Integer.parseInt(numberOnly);
        String resultString = String.valueOf(result);
        holder.nbrParticipants.setText(resultString);
        holder.eventName.setText(eventList.get(position).getEventName());
        holder.time.setText(eventList.get(position).getTime());
        holder.date.setText(eventList.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public static class ChildViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView date;
        TextView time;
        TextView eventName;
        TextView nbrParticipants;

        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage=itemView.findViewById(R.id.item_image);
            date=itemView.findViewById(R.id.eventDate);
            eventName=itemView.findViewById(R.id.eventTitle);
            time=itemView.findViewById(R.id.eventTime);
            nbrParticipants=itemView.findViewById(R.id.eventParticipants);
        }
    }
}
