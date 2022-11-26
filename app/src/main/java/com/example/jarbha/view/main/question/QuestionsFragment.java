package com.example.jarbha.view.main.question;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jarbha.R;
import com.example.jarbha.databinding.FragmentQuestionsBinding;
import com.example.jarbha.model.entity.QuestionEntity;

import java.util.ArrayList;

public class QuestionsFragment extends Fragment implements QuestionAdapter.QuestionAdapterClickListeners {
    //region Variables
    private QuestionAdapter questionAdapter;
    private QuestionsViewModel questionsViewModel;
    private FragmentQuestionsBinding binding;
    private Bundle bundle;
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
        bundle = getArguments();

        questionsViewModel = new ViewModelProvider(this).get(QuestionsViewModel.class);

        setupRecyclerView();

        questionsViewModel.getAllQuestionByCategoryId(bundle.getInt("CATEGORY_ID")).observe(requireActivity(), categoryQuestionEntities -> {
            questionsViewModel.getQuestionById(categoryQuestionEntities.get(0).getId_question()).observe(requireActivity(), questionEntity -> {
                binding.QuestionFragmentCardTextQuestions.setText(questionEntity.getQuestion());
            });
        });

        return binding.getRoot();
    }
    //endregion


    //region Methods
    private void setupRecyclerView() {
        questionAdapter = new QuestionAdapter(new ArrayList<>(), this);
        binding.activityMainRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        binding.activityMainRecyclerView.setAdapter(questionAdapter);
    }

    @Override
    public void onItemRecyclerViewQuestionCardViewQuestionContainerClickListener(int position, QuestionEntity questionEntity) {

    }

    //endregion
}