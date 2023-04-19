package com.example.sportmatch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.MainViewHolder> {

    private List<AllCategory> allCategoryList;
    private Context context;

    public ParentAdapter(List<AllCategory> allCategoryList, Context context) {
        this.allCategoryList = allCategoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_recycler_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {

        holder.title.setText(allCategoryList.get(position).getTitle());
        setChildRecycler(holder.recyclerView,allCategoryList.get(position).getEventList());
    }

    @Override
    public int getItemCount() {
        return allCategoryList.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView title;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.category_title);
            recyclerView= itemView.findViewById(R.id.item_recycler);
        }
    }

    private void setChildRecycler(RecyclerView recyclerView, ArrayList<Event> eventList)
    {
        ChildAdapter childAdapter = new ChildAdapter(eventList,context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(childAdapter);
    }
}
