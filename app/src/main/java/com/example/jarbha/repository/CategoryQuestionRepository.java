package com.example.jarbha.repository;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.jarbha.model.dao.CategoryDao;
import com.example.jarbha.model.dao.CategoryQuestionDao;
import com.example.jarbha.model.database.JarbhaDatabase;
import com.example.jarbha.model.entity.CategoryEntity;
import com.example.jarbha.model.entity.CategoryQuestionEntity;

import java.util.List;

public class CategoryQuestionRepository {
    //region Variables
    CategoryQuestionDao categoryQuestionDao;
    //endregion

    //region Constructor
    public CategoryQuestionRepository(Application application) {
        JarbhaDatabase jarbhaDatabase = JarbhaDatabase.getInstance(application);
        categoryQuestionDao = jarbhaDatabase.categoryQuestionDao();
    }
    //endregion

    //region Methods
    public LiveData<List<CategoryQuestionEntity>> getAllCategories() {
        return categoryQuestionDao.getAllCategories();
    }

    public void insertCategoryQuestion(CategoryQuestionEntity categoryQuestionEntity) {
        new InsertCategoryQuestionTask(categoryQuestionDao).execute(categoryQuestionEntity);
    }
    //endregion

    //region Async tasks
    private static class InsertCategoryQuestionTask extends AsyncTask<CategoryQuestionEntity, Void, Void> {
        //region Variables
        CategoryQuestionDao categoryQuestionDao;
        //endregion

        //region Constructor
        public InsertCategoryQuestionTask(CategoryQuestionDao categoryQuestionDao) {
            this.categoryQuestionDao = categoryQuestionDao;
        }
        //endregion

        @Override
        protected Void doInBackground(CategoryQuestionEntity... categoryQuestionEntities) {
            categoryQuestionDao.insert(categoryQuestionEntities[0]);
            return null;
        }
    }

    //endregion

}