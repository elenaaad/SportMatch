package com.example.sportmatch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder> {

    ArrayList<CategoryItemClass> categoryItemClassList;
    Context context;

    public ChildAdapter(ArrayList<CategoryItemClass> categoryItemClassList, Context context) {
        this.categoryItemClassList = categoryItemClassList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChildViewHolder( LayoutInflater.from(context).inflate(R.layout.category_row_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChildAdapter.ChildViewHolder holder, int position) {
        holder.itemImage.setImageResource(categoryItemClassList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return categoryItemClassList.size();
    }

    public static class ChildViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;

        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage=itemView.findViewById(R.id.item_image);
        }
    }
}
