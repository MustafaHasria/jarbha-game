package com.example.jarbha.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.jarbha.model.entity.CategoryEntity;
import com.example.jarbha.model.entity.QuestionEntity;

import java.util.List;

@Dao
public interface CategoryDao {

    @Insert
    void insert(CategoryEntity categoryEntity);

    @Update
    void update(CategoryEntity categoryEntity);

    @Delete
    void delete(CategoryEntity categoryEntity);

    @Query("Select * From category_table")
    LiveData<List<CategoryEntity>> getAllCategories();
}
