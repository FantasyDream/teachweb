package com.teachweb.service;

import com.teachweb.model.Subjects;

import java.util.List;

public interface SubjectsService {

    void addSubjects(Subjects subjects);

    void deleteSubjects(Subjects subjects);

    void updateSubjects(Subjects subjects);

    Subjects getSubjects(Subjects subjects);

    List<Subjects> createSubject(int range, int subject_no);
}
