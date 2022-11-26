package com.example.jarbha.view.main.question;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.jarbha.model.entity.QuestionEntity;
import com.example.jarbha.repository.QuestionRepositroy;

import java.util.List;

public class QuestionsViewModel extends AndroidViewModel {

    //region Variables
    QuestionRepositroy questionRepositroy;
    //endregion

    public QuestionsViewModel(@NonNull Application application) {
        super(application);
        questionRepositroy = new QuestionRepositroy(application);
    }

    //region Methods
    public void insert(QuestionEntity questionEntity) {
        questionRepositroy.insertQuestion(questionEntity);
    }
    public void delete(QuestionEntity questionEntity) {
        questionRepositroy.deleteQuestion(questionEntity);

    }
    public void update(QuestionEntity questionEntity) {
        questionRepositroy.updateQuestion(questionEntity);

    }
    public LiveData<List<QuestionEntity>> getAllQuestion() {
        return questionRepositroy.getQuestion();
    }

    //endregion
}
