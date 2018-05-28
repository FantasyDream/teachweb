package com.teachweb.service.impl;

import com.teachweb.dao.TestDao;
import com.teachweb.model.Subjects;
import com.teachweb.model.Test;
import com.teachweb.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestDao testDao;

    @Override
    public void addTest(Test test) {
        testDao.addTest(test);
    }

    @Override
    public void deleteTest(Test test) {
        testDao.deleteTest(test);
    }

    @Override
    public Test getTest(Test test) {
        return testDao.getTest(test);
    }

    @Override
    public List<Test> listTest(int classId) {
        return testDao.listTest(classId);
    }

    @Override
    public void updateTest(Test test) {
        testDao.updateTest(test);
    }

    @Override
    public void addSubject(Test test,Subjects subjects) {
        testDao.addSubject(test.getId(),subjects.getId());
    }

    @Override
    public List<Subjects> listSubject(int testid) {
        return testDao.listSubject(testid);
    }
}
