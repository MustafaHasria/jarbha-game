package com.example.jarbha.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.jarbha.model.dao.CategoryDao;
import com.example.jarbha.model.database.JarbhaDatabase;
import com.example.jarbha.model.entity.CategoryEntity;

import java.util.List;

public class CategoryRepository {
    //region Variables
    CategoryDao categoryDao;
    //endregion

    //region Constructor
    public CategoryRepository(Application application) {
        JarbhaDatabase jarbhaDatabase = JarbhaDatabase.getInstance(application);
        categoryDao = jarbhaDatabase.categoryDao();
    }
    //endregion

    //region Methods
    public LiveData<List<CategoryEntity>> getCategories() {
        return categoryDao.getAllCategories();
    }

    public void insertCategory(CategoryEntity categoryEntity) {
        new InsertCategoryTask(categoryDao).execute(categoryEntity);
    }
    public void deleteCategory(CategoryEntity categoryEntity) {
        new DeleteCategoryTask(categoryDao).execute(categoryEntity);
    }
    public void updateCategory(CategoryEntity categoryEntity) {
        new UpdateCategoryTask(categoryDao).execute(categoryEntity);
    }

    public LiveData<List<CategoryEntity>> getAllCategories() {
        return getAllCategories();
    }

    //endregion

    //region Async tasks insert
    private static class InsertCategoryTask extends AsyncTask<CategoryEntity, Void, Void> {
        //region Variables
        CategoryDao categoryDao;
        //endregion

        //region Constructor
        public InsertCategoryTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }
        //endregion

        @Override
        protected Void doInBackground(CategoryEntity... categoryEntities) {
            categoryDao.insert(categoryEntities[0]);
            return null;
        }
    }

    //endregion

    //region Async tasks delete
    private static class DeleteCategoryTask extends AsyncTask<CategoryEntity, Void, Void> {
        //region Variables
        CategoryDao categoryDao;
        //endregion

        //region Constructor
        public DeleteCategoryTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }
        //endregion

        @Override
        protected Void doInBackground(CategoryEntity... categoryEntities) {
            categoryDao.delete(categoryEntities[0]);


            return null;
        }
    }

    //endregion

    //region Async tasks update
    private static class UpdateCategoryTask extends AsyncTask<CategoryEntity, Void, Void> {
        //region Variables
        CategoryDao categoryDao;
        //endregion

        //region Constructor
        public UpdateCategoryTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }
        //endregion

        @Override
        protected Void doInBackground(CategoryEntity... categoryEntities) {
            categoryDao.update(categoryEntities[0]);


            return null;
        }
    }

    //endregion
}