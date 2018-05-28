package com.teachweb.service.impl;

import com.teachweb.dao.AnswerDao;
import com.teachweb.dao.GradeDao;
import com.teachweb.dao.TestDao;
import com.teachweb.model.Answer;
import com.teachweb.model.Grade;
import com.teachweb.model.Subjects;
import com.teachweb.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeDao gradeDao;

    @Autowired
    AnswerDao answerDao;

    @Autowired
    TestDao testDao;

    @Override
    public void getGrade(Grade grade) {
        gradeDao.getGrade(grade);
    }

    @Override
    public void addGrade(Grade grade) {
        gradeDao.addGrade(grade);
    }

    @Override
    public void updateGrade(Grade grade) {
        gradeDao.updateGrade(grade);
    }

    @Override
    public void deleteGrade(Grade grade) {
        gradeDao.deleteGrade(grade);
    }

    @Override
    public List<Grade> listGrade(int studentId) {
        return gradeDao.listGrade(studentId);
    }

    @Override
    public void calculateGrade(Grade grade) {
        List<Subjects> subjects = testDao.listSubject(grade.getTestid());
        List<Answer> answers = answerDao.listAnswer(grade.getId());
        int right = 0;
        int totle = subjects.size();
        for(int i=0;i<subjects.size();i++){
            Subjects subjects1 = subjects.get(i);
            Answer answer = answers.get(i);
            if(subjects1.getAnswer().equals(answer.getAnswer())){
                answer.setRight(true);
                answerDao.updateAnswer(answer);
                right++;
            } else {
                answer.setRight(false);
                answerDao.updateAnswer(answer);
            }
        }
        double point = (right*1.0/totle)*100;
        point = (double)Math.round(point*100)/100;
        grade.setGrade(point);
        gradeDao.updateGrade(grade);
    }
}
