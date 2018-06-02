package com.teachweb.service;

import com.teachweb.model.Classs;
import com.teachweb.model.Student;
import com.teachweb.model.Test;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);

    void deleteStudent(Student student);

    Student getStudent(Student student);

    List<Student> listStudent();

    void updateStudent(Student student);

    void joinClasss(Student student,String invitation);

    List<Classs> listClasss(int studentId);

    void addAnswers(Test test, String[] anwsers, int studentId);
}
