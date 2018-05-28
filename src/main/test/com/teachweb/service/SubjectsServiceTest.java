package com.teachweb.service;

import com.teachweb.model.Subjects;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class SubjectsServiceTest {

    @Autowired
    SubjectsService subjectsService;

    @Test
    public void addSubjects() {
    }

    @Test
    public void deleteSubjects() {
    }

    @Test
    public void updateSubjects() {
    }

    @Test
    public void getSubjects() {
        Subjects subjects = new Subjects();
        subjects.setId(6);
        subjects.setExpression("(2-2)*(1-1)");
        subjects.setAnswer("0");
        System.out.println(subjectsService.getSubjects(subjects));
    }

    @Test
    public void createSubject() {
        subjectsService.createSubject(3,3);
    }
}