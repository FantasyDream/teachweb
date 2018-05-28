package com.teachweb.dao;

import com.teachweb.model.Subjects;

import java.util.List;

public interface SubjectsDao {

    void addSubjects(Subjects subjects);

    void deleteSubjects(Subjects subjects);

    void updateSubjects(Subjects subjects);

    Subjects getSubjects(Subjects subjects);

    List<Subjects> listSubjects(int testId);

    int getLastInsertId();


}
