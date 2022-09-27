package com.example.jarbha.repository;

import android.app.Application;

import com.example.jarbha.model.dao.CategoryDao;
import com.example.jarbha.model.database.JarbhaDatabase;

public class CategoryRepository {
    //region Variables
    CategoryDao categoryDao;
    //endregion

    //region Constructor
    public CategoryRepository(Application application){
        JarbhaDatabase jarbhaDatabase = JarbhaDatabase.getInstance(application);
        categoryDao= jarbhaDatabase.categoryDao();
    }
    //endregion

}