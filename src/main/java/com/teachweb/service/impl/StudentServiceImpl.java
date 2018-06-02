package com.teachweb.service.impl;

import com.teachweb.dao.*;
import com.teachweb.model.*;
import com.teachweb.service.AnswerService;
import com.teachweb.service.GradeService;
import com.teachweb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private ClasssDao classsDao;

    @Autowired
    private GradeService gradeDao;

    @Autowired
    private AnswerDao answerDao;

    @Autowired
    private TestDao testDao;

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentDao.deleteStudent(student);
    }

    @Override
    public Student getStudent(Student student) {
        return studentDao.getStudent(student);
    }

    @Override
    public List<Student> listStudent() {
        return studentDao.listStudent();
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
    public void joinClasss(Student student, String invitation) {
        Classs classs = new Classs();
        classs.setInvitation(invitation);
        if(classsDao.getClasss(classs)==null){
            System.out.println(invitation);
        }
        int studentId = (int) student.getId();
        int classsId = (int) classsDao.getClasss(classs).getId();
        studentDao.joinClasss(classsId,studentId);
    }

    @Override
    public List<Classs> listClasss(int studentId) {
        return studentDao.listClasss(studentId);
    }

    @Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
    public void addAnswers(Test test,String[] anwsers,int studentId){
        Grade grade = new Grade();
        grade.setStudentid(studentId);
        grade.setTestid(test.getId());
        gradeDao.addGrade(grade);
        grade = gradeDao.getGrade(grade);
        List<Subjects> subjects = testDao.listSubject(test.getId());
        for (int i = 0; i < subjects.size(); i++) {
            Answer answer = new Answer();
            answer.setGradeid(grade.getId());
            answer.setSubjectid(subjects.get(i).getId());
            answer.setAnswer(anwsers[i]);
            answerDao.addAnswer(answer);
        }
        gradeDao.calculateGrade(grade);
    }

}
