package com.example.jarbha.view.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jarbha.R;
import com.example.jarbha.model.entity.CategoryEntity;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    //region Variables
    private List<CategoryEntity> categoryEntityList;
    //endregion

    //region Constructor

    public CategoryAdapter(List<CategoryEntity> categoryEntityList) {
        this.categoryEntityList = categoryEntityList;
    }

    //endregion

    //region Adapter
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view_category, parent, false);
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.itemRecyclerViewCategoryTextViewName.setText(categoryEntityList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return categoryEntityList.size();
    }
    //endregion

    //region View holder
    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        //region Components
        CardView itemRecyclerViewCategoryCardViewMainContainer;
        TextView itemRecyclerViewCategoryTextViewName;
        //endregion

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            itemRecyclerViewCategoryCardViewMainContainer = itemView.findViewById(R.id.item_recycler_view_category_card_view_main_container);
            itemRecyclerViewCategoryTextViewName = itemView.findViewById(R.id.item_recycler_view_category_text_view_name);
        }
    }
    //endregion
}
