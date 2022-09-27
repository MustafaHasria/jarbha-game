package com.example.jarbha.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.jarbha.model.entity.QuestionEntity;

import java.util.List;

@Dao
public interface QuestionDao {

    @Insert
    void insert(QuestionEntity questionEntity);

    @Update
    void update(QuestionEntity questionEntity);

    @Delete
    void delete(QuestionEntity questionEntity);

    @Query("Select * from question_table where is_hard")
    LiveData<List<QuestionEntity>> getAllHardQuestion();

    @Query("Delete from question_table")
    Void deleteAll();
}
