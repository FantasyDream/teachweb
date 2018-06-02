package com.teachweb.service;

import com.teachweb.model.Answer;
import com.teachweb.model.Grade;

import java.util.List;

public interface GradeService {

    Grade getGrade(Grade grade);

    void addGrade(Grade grade);

    void updateGrade(Grade grade);

    void deleteGrade(Grade grade);

    List<Grade> listGrade(int studentId);

    void calculateGrade(Grade grade);
}
