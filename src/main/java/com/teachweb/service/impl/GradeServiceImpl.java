package com.teachweb.service.impl;

import com.teachweb.dao.AnswerDao;
import com.teachweb.dao.GradeDao;
import com.teachweb.dao.TestDao;
import com.teachweb.model.*;
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
    public Grade getGrade(Grade grade) {
        return gradeDao.getGrade(grade);
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
    public List<Test> listGradeByStudent(int classId) {
        return gradeDao.listGradeByStudent(classId);
    }

    public List<Student> listGradeByTest(int testId) {
        return gradeDao.listGradeByTest(testId);
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
