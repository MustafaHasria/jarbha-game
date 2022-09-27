package com.example.jarbha.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "question_table")
public class QuestionEntity {

    //region Properties
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "question")
    private String question;
    @ColumnInfo(name = "answer")
    private String answer;
    @ColumnInfo(name = "wrong_answer_one")
    private String wrongAnswerOne;
    @ColumnInfo(name = "wrong_answer_two")
    private String wrongAnswerTwo;
    @ColumnInfo(name = "wrong_answer_three")
    private String wrongAnswerThree;
    @ColumnInfo(name = "is_hard")
    private boolean isHard;
    @ColumnInfo(name = "name_category")
    private String nameCategory;
    //endregion

    //region Constructor
    public QuestionEntity(String question, String answer, String wrongAnswerOne, String wrongAnswerTwo, String wrongAnswerThree, boolean isHard, String nameCategory) {
        this.question = question;
        this.answer = answer;
        this.wrongAnswerOne = wrongAnswerOne;
        this.wrongAnswerTwo = wrongAnswerTwo;
        this.wrongAnswerThree = wrongAnswerThree;
        this.isHard = isHard;
        this.nameCategory = nameCategory;
    }

    //endregion

    //region Setters & Getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getWrongAnswerOne() {
        return wrongAnswerOne;
    }

    public void setWrongAnswerOne(String wrongAnswerOne) {
        this.wrongAnswerOne = wrongAnswerOne;
    }

    public String getWrongAnswerTwo() {
        return wrongAnswerTwo;
    }

    public void setWrongAnswerTwo(String wrongAnswerTwo) {
        this.wrongAnswerTwo = wrongAnswerTwo;
    }

    public String getWrongAnswerThree() {
        return wrongAnswerThree;
    }

    public void setWrongAnswerThree(String wrongAnswerThree) {
        this.wrongAnswerThree = wrongAnswerThree;
    }

    public boolean isHard() {
        return isHard;
    }

    public void setHard(boolean hard) {
        isHard = hard;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    //endregion

}
