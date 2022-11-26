package com.example.jarbha.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.jarbha.model.entity.CategoryQuestionEntity;

import java.util.List;

@Dao
public interface CategoryQuestionDao {

    @Insert
    void insert(CategoryQuestionEntity categoryQuestionEntity);

    @Update
    void update(CategoryQuestionEntity categoryQuestionEntity);

    @Delete
    void delete(CategoryQuestionEntity categoryQuestionEntity);

    @Query("Select * From CATEGORY_QUESTION_TABLE")
    LiveData<List<CategoryQuestionEntity>> getAllQuestions();

    @Query("Select * From CATEGORY_QUESTION_TABLE where id_category=:categoryId ")
    LiveData<List<CategoryQuestionEntity>> getAllQuestionsByCategoryId(int categoryId);
}
