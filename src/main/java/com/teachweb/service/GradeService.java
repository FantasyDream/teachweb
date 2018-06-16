package com.teachweb.service;

import com.teachweb.model.Grade;
import com.teachweb.model.Student;
import com.teachweb.model.Test;

import java.util.List;

public interface GradeService {

    Grade getGrade(Grade grade);

    void addGrade(Grade grade);

    void updateGrade(Grade grade);

    void deleteGrade(Grade grade);

    List<Test> listGradeByStudent(int classId);

    List<Student> listGradeByTest(int testId);

    void calculateGrade(Grade grade);
}
