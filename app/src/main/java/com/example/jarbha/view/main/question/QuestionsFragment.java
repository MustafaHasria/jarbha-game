package com.example.jarbha.view.main.question;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jarbha.R;
import com.example.jarbha.databinding.FragmentHomeBinding;
import com.example.jarbha.databinding.FragmentQuestionsBinding;
import com.example.jarbha.model.entity.CategoryEntity;
import com.example.jarbha.model.entity.QuestionEntity;
import com.example.jarbha.view.main.home.CategoryAdapter;
import com.example.jarbha.view.main.home.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class QuestionsFragment extends Fragment implements QuestionAdapter.QuestionAdapterClickListeners {
    //region Variables
    private QuestionAdapter questionAdapter;
    private QuestionsViewModel questionsViewModel;
    private FragmentQuestionsBinding binding;
    //endregion
    //region Life cycle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_questions, container, false);
        binding = FragmentQuestionsBinding.bind(view);


        questionsViewModel = new ViewModelProvider(this).get(QuestionsViewModel.class);

        setupRecyclerView();

        questionsViewModel.getAllQuestion().observe(requireActivity(), new Observer<List<QuestionEntity>>() {
            @Override
            public void onChanged(List<QuestionEntity> questionEntities) {
                questionAdapter.updateList(questionEntities);
            }
        });

        return binding.getRoot();
    }
    //endregion



    //region Methods
    private void setupRecyclerView() {
        questionAdapter = new QuestionAdapter(new ArrayList<>(),this);
        binding.activityMainRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
        binding.activityMainRecyclerView.setAdapter(questionAdapter);
    }

    @Override
    public void onItemRecyclerViewQuestionCardViewQuestionContainerClickListener(int position, QuestionEntity questionEntity) {
        
    }

    //endregion
}