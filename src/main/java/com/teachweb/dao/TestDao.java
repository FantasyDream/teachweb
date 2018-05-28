package com.teachweb.dao;

import com.teachweb.model.Subjects;
import com.teachweb.model.Test;
import java.util.List;

public interface TestDao {
    void addTest(Test test);

    void deleteTest(Test test);

    Test getTest(Test test);

    List<Test> listTest(int classId);

    void updateTest(Test test);

    void addSubject(int testId,int subjectId);

    List<Subjects> listSubject(int testid);
}
