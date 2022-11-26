package com.example.jarbha.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.jarbha.model.dao.QuestionDao;
import com.example.jarbha.model.database.JarbhaDatabase;
import com.example.jarbha.model.entity.QuestionEntity;

import java.util.List;

public class QuestionRepositroy {
    //region Variables
    QuestionDao questionDao;
    //endregion

    //region Constructor
    public QuestionRepositroy(Application application) {
        JarbhaDatabase jarbhaDatabase = JarbhaDatabase.getInstance(application);
        questionDao = jarbhaDatabase.questionDao();
    }
    //endregion

    //region Methods
    public LiveData<List<QuestionEntity>> getQuestion() {
        return questionDao.getAllHardQuestion();
    }

    public LiveData<QuestionEntity> getQuestionById(int questionId) {
        return questionDao.getQuestionById(questionId);
    }


    public void insertQuestion(QuestionEntity questionEntity) {
        new InsertQuestionTask(questionDao).execute(questionEntity);
    }

    public void deleteQuestion(QuestionEntity questionEntity) {
        new DeleteQuestionTask(questionDao).execute(questionEntity);
    }

    public void updateQuestion(QuestionEntity questionEntity) {
        new UpdateQuestionTask(questionDao).execute(questionEntity);
    }
    //endregion

    //region Async tasks
    private static class InsertQuestionTask extends AsyncTask<QuestionEntity, Void, Void> {
        //region Variables
        QuestionDao questionDao;
        //endregion

        //region Constructor
        public InsertQuestionTask(QuestionDao questionDao) {
            this.questionDao = questionDao;
        }
        //endregion

        @Override
        protected Void doInBackground(QuestionEntity... questionEntities) {
            questionDao.insert(questionEntities[0]);
            return null;
        }
    }

    //endregion


    //region Async tasks
    private static class DeleteQuestionTask extends AsyncTask<QuestionEntity, Void, Void> {
        //region Variables
        QuestionDao questionDao;
        //endregion

        //region Constructor
        public DeleteQuestionTask(QuestionDao questionDao) {
            this.questionDao = questionDao;
        }
        //endregion

        @Override
        protected Void doInBackground(QuestionEntity... questionEntities) {
            questionDao.delete(questionEntities[0]);
            return null;
        }
    }

    //endregion


    //region Async tasks
    private static class UpdateQuestionTask extends AsyncTask<QuestionEntity, Void, Void> {
        //region Variables
        QuestionDao questionDao;
        //endregion

        //region Constructor
        public UpdateQuestionTask(QuestionDao questionDao) {
            this.questionDao = questionDao;
        }
        //endregion

        @Override
        protected Void doInBackground(QuestionEntity... questionEntities) {
            questionDao.update(questionEntities[0]);
            return null;
        }
    }

    //endregion
}