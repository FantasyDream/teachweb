package com.teachweb.dao;

import com.teachweb.model.Answer;
import com.teachweb.model.Grade;
import com.teachweb.model.Student;
import com.teachweb.model.Test;

import java.util.List;

public interface GradeDao {
    Grade getGrade(Grade grade);

    void addGrade(Grade grade);

    void updateGrade(Grade grade);

    void deleteGrade(Grade grade);

    List<Test> listGradeByStudent(int classId);

    List<Student> listGradeByTest(int testId);

}
