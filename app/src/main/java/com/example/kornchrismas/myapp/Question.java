package com.example.kornchrismas.myapp;

public class Question {

    int intQuestion;

    public interface onQuestionChangeListener{
        void onQuestionChangeListener(Question question);
    }

    private onQuestionChangeListener onQuestionChangeListener;

    public void setOnQuestionChangeListener(onQuestionChangeListener onQuestionChangeListener){
        this.onQuestionChangeListener=onQuestionChangeListener;
    }

    public int getIntQuestion(){
        return intQuestion;
    }

    public void setIntQuestion(int intQuestion){
        this.intQuestion = intQuestion;
        if (this.onQuestionChangeListener != null){
            this.onQuestionChangeListener.onQuestionChangeListener(this);
        }
    }

}
