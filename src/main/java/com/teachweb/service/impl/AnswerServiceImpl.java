package com.teachweb.service.impl;

import com.teachweb.dao.AnswerDao;
import com.teachweb.model.Answer;
import com.teachweb.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerDao answerDao;

    @Override
    public void addAnswer(Answer answer) {
        answerDao.addAnswer(answer);
    }

    @Override
    public void deleteAnswer(Answer answer) {
        answerDao.deleteAnswer(answer);
    }

    @Override
    public void updateAnswer(Answer answer) {
        answerDao.updateAnswer(answer);
    }

    @Override
    public Answer getAnswer(Answer answer) {
        return answerDao.getAnswer(answer);
    }

    @Override
    public List<Answer> listAnswer(int gradeId) {
        return answerDao.listAnswer(gradeId);
    }
}
