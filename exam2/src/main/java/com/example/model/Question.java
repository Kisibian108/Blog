package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;


@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String question;
    private String answer;

    @ManyToOne
    @JoinColumn(name = "questionType_id", referencedColumnName = "id")
    @JsonBackReference
    private QuestionType questionType;

    private String date;
    private String status;

    public Question() {
    }

    public Question(String title, String question, QuestionType questionType) {
        this.title = title;
        this.question = question;
        this.questionType = questionType;
    }

    public Question(int id, String title, QuestionType questionType, String date, String status) {
        this.id = id;
        this.title = title;
        this.questionType = questionType;
        this.date = date;
        this.status = status;
    }

    public Question(int id, String title, String question, QuestionType questionType) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.questionType = questionType;
    }

    public Question(int id, String title, String question, String answer, QuestionType questionType, String date, String status) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.answer = answer;
        this.questionType = questionType;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
