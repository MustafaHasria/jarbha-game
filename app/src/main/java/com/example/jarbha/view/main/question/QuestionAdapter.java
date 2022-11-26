package com.example.jarbha.view.main.question;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jarbha.R;
import com.example.jarbha.model.entity.QuestionEntity;


import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    //region Variables
    private List<QuestionEntity> questionEntityList;
    private QuestionAdapter.QuestionAdapterClickListeners clickListeners;
    //endregion

    //region Constructor

    public QuestionAdapter(List<QuestionEntity> questionEntityList , QuestionAdapter.QuestionAdapterClickListeners clickListeners) {
        this.questionEntityList = questionEntityList;
        this.clickListeners = clickListeners;
    }


    //endregion

    //region Adapter
    @NonNull
    @Override
    public QuestionAdapter.QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view_question, parent, false);
        return new QuestionAdapter.QuestionViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull QuestionAdapter.QuestionViewHolder holder, int position) {


    }
    @Override
    public int getItemCount() {
        return 4;
    }
    //endregion

    //region Methods
    public void updateList(List<QuestionEntity> questionEntityList) {
        this.questionEntityList.clear();
        this.questionEntityList = questionEntityList;
        notifyDataSetChanged();
    }
    //endregion

    //region Interface
    interface QuestionAdapterClickListeners {
        void onItemRecyclerViewQuestionCardViewQuestionContainerClickListener(int position, QuestionEntity questionEntity);
    }
    //endregion

    //region View holder
    public class QuestionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //region Components
        CardView itemRecyclerViewQuestionCardViewQuestionContainer;

        //endregion


        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            itemRecyclerViewQuestionCardViewQuestionContainer = itemView.findViewById(R.id.item_recycler_view_question_card_view_answer_container);

            itemRecyclerViewQuestionCardViewQuestionContainer.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListeners.onItemRecyclerViewQuestionCardViewQuestionContainerClickListener(getAdapterPosition(), questionEntityList.get(getAdapterPosition()));
        }
    }
    //endregion

    }
