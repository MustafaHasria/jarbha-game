package com.example.jarbha.view.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.jarbha.model.entity.CategoryEntity;
import com.example.jarbha.repository.CategoryRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    //region Variables
    CategoryRepository categoryRepository;
    //endregion

    //region Constructor
    public MainViewModel(@NonNull Application application) {
        super(application);
        categoryRepository = new CategoryRepository(application);
    }
    //endregion

    //region Methods
    public void insert(CategoryEntity categoryEntity) {
        categoryRepository.insertCategory(categoryEntity);
    }
    public void delete(CategoryEntity categoryEntity) {
        categoryRepository.deleteCategory(categoryEntity);

    }
    public void update(CategoryEntity categoryEntity) {
        categoryRepository.updateCategory(categoryEntity);

    }
    public LiveData<List<CategoryEntity>> getAllCategories() {
        return categoryRepository.getCategories();
    }

    //endregion
}
