package com.teachweb.service;

import com.teachweb.model.Subjects;
import com.teachweb.model.Test;

import java.util.List;

public interface TestService {
    void addTest(Test test);

    void deleteTest(Test test);

    Test getTest(Test test);

    List<Test> listTest(int classId);

    void updateTest(Test test);

    void addSubject(Test test,Subjects subjects);

    List<Subjects> listSubject(int testid);
}
