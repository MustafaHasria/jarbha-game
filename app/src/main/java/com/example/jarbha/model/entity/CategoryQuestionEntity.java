package com.example.jarbha.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "category_question_table")
public class CategoryQuestionEntity {

    //region Properties
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "id_category")
    private int id_category;
    @ColumnInfo(name = "id_question")
    private int id_question;
    //endregion

    //region constructor

    public CategoryQuestionEntity(int id_category, int id_question) {
        this.id_category = id_category;
        this.id_question = id_question;
    }

    //endregion

    //region Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }


    //endregion
}
