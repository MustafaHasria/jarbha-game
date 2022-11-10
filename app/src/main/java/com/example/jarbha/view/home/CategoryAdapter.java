package com.example.jarbha.view.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    private CategoryAdapterClickListeners clickListeners;
    //endregion

    //region Constructor

    public CategoryAdapter(List<CategoryEntity> categoryEntityList, CategoryAdapterClickListeners clickListeners) {
        this.categoryEntityList = categoryEntityList;
        this.clickListeners = clickListeners;
    }


    //endregion

    //region Adapter
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view_category, parent, false);
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.itemRecyclerViewCategoryTextViewName.setText(categoryEntityList.get(position).getName());
        holder.itemRecyclerViewCategoryPicture.setImageResource(categoryEntityList.get(position).getPicture());
        //Bad way
//        holder.itemRecyclerViewCategoryPicture.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return categoryEntityList.size();
    }
    //endregion

    //region Methods
    public void updateList(List<CategoryEntity> categoryEntityList) {
        this.categoryEntityList.clear();
        this.categoryEntityList = categoryEntityList;
        notifyDataSetChanged();
    }
    //endregion

    //region Interface
    interface CategoryAdapterClickListeners {
        void onItemRecyclerViewCategoryCardViewMainContainerClickListener(int position, CategoryEntity categoryEntity);
    }
    //endregion

    //region View holder
    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //region Components
        CardView itemRecyclerViewCategoryCardViewMainContainer;
        TextView itemRecyclerViewCategoryTextViewName;
        ImageView itemRecyclerViewCategoryPicture;
        //endregion

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            itemRecyclerViewCategoryCardViewMainContainer = itemView.findViewById(R.id.item_recycler_view_category_card_view_main_container);
            itemRecyclerViewCategoryTextViewName = itemView.findViewById(R.id.item_recycler_view_category_text_view_name);
            itemRecyclerViewCategoryPicture = itemView.findViewById(R.id.item_recycler_view_category_picture);

            itemRecyclerViewCategoryCardViewMainContainer.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListeners.onItemRecyclerViewCategoryCardViewMainContainerClickListener(getAdapterPosition(), categoryEntityList.get(getAdapterPosition()));
        }
    }
    //endregion
}
