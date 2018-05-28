package com.teachweb.service;

import com.teachweb.model.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);

    void deleteStudent(Student student);

    Student getStudent(Student student);

    List<Student> listStudent();

    void updateStudent(Student student);

    void joinClasss(Student student,String invitation);
}
