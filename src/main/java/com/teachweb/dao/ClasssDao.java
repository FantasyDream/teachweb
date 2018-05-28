package com.teachweb.dao;

import com.teachweb.model.Classs;
import com.teachweb.model.Student;

import java.util.List;

public interface ClasssDao {

    void addClasss(Classs classs);

    void deleteClasss(Classs classs);

    void updateClasss(Classs classs);

    Classs getClasss(Classs classs);

    List<Classs> listClasss(int teacherid);

    List<Student> listStudent(int classsId);
}
