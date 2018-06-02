package com.teachweb.dao;

import com.teachweb.model.Classs;
import com.teachweb.model.Student;
import com.teachweb.model.Test;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);

    void deleteStudent(Student student);

    Student getStudent(Student student);

    List<Student> listStudent();

    void updateStudent(Student student);

    void joinClasss(int classsId, int studentId);

    List<Classs> listClasss(int studentId);
}
