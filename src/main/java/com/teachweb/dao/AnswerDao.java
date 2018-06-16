package com.teachweb.dao;

import com.teachweb.model.Answer;

import java.util.List;

public interface AnswerDao {

    void addAnswer(Answer answer);

    void deleteAnswer(Answer answer);

    int updateAnswer(Answer answer);

    Answer getAnswer(Answer answer);

    List<Answer> listAnswer(int gradeId);

}
