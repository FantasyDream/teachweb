package com.teachweb.service.impl;

import com.teachweb.dao.ClasssDao;
import com.teachweb.dao.StudentDao;
import com.teachweb.model.Classs;
import com.teachweb.model.Student;
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
}
