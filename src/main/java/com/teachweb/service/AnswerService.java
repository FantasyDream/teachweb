package com.teachweb.service;

import com.teachweb.model.Answer;

import java.util.List;

public interface AnswerService {

    void addAnswer(Answer answer);

    void deleteAnswer(Answer answer);

    void updateAnswer(Answer answer);

    Answer getAnswer(Answer answer);

    List<Answer> listAnswer(int gradeId);

}

