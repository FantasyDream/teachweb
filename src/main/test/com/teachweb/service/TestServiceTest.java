package com.teachweb.service;

import com.teachweb.dao.TestDao;
import com.teachweb.model.Subjects;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class TestServiceTest {

    @Autowired
    TestService testDao;

    @Test
    public void addTest() {
        com.teachweb.model.Test test = new com.teachweb.model.Test();
        test.setClassid(1);
        test.setName("first test");
        testDao.addTest(test);
    }

    @Test
    public void deleteTest() {
        com.teachweb.model.Test test = new com.teachweb.model.Test();
        test.setId(1);
        testDao.deleteTest(test);
    }

    @Test
    public void getTest() {
        com.teachweb.model.Test test = new com.teachweb.model.Test();
        test.setId(2);
        test.setName("first test");
        test.setClassid(1);
        System.out.println(testDao.getTest(test));
    }

    @Test
    public void listTest() {
        List<com.teachweb.model.Test> tests = testDao.listTest(1);
        Iterator<com.teachweb.model.Test> iterator = tests.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getId());
        }

    }

    @Test
    public void updateTest() {
    }

    @Test
    public void addSubject() {
        com.teachweb.model.Test test = new com.teachweb.model.Test();
        test.setId(2);
        Subjects subjects = new Subjects();
        subjects.setId(1);
        testDao.addSubject(test,subjects);
    }

    @Test
    public void listSubject() {
        List<Subjects> subjects = testDao.listSubject(2);
        Iterator<Subjects> iterator = subjects.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getExpression());
        }
    }
}