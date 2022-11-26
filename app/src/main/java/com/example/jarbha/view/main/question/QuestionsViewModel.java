package com.example.jarbha.view.main.question;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.jarbha.model.entity.CategoryQuestionEntity;
import com.example.jarbha.model.entity.QuestionEntity;
import com.example.jarbha.repository.CategoryQuestionRepository;
import com.example.jarbha.repository.QuestionRepositroy;

import java.util.List;

public class QuestionsViewModel extends AndroidViewModel {

    //region Variables
    CategoryQuestionRepository categoryQuestionRepository;
    QuestionRepositroy questionRepositroy;
    //endregion

    public QuestionsViewModel(@NonNull Application application) {
        super(application);
        categoryQuestionRepository = new CategoryQuestionRepository(application);
        questionRepositroy = new QuestionRepositroy(application);
    }

    //region Methods
    public LiveData<List<CategoryQuestionEntity>> getAllQuestion() {
        return categoryQuestionRepository.getAllCategoryQuestions();
    }

    public LiveData<List<CategoryQuestionEntity>> getAllQuestionByCategoryId(int categoryId) {
        return categoryQuestionRepository.getAllQuestionsByCategoryId(categoryId);
    }

    public LiveData<QuestionEntity> getQuestionById(int questionId) {
        return questionRepositroy.getQuestionById(questionId);
    }

    //endregion
}
