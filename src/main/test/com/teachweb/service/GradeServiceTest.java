package com.teachweb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class GradeServiceTest {

    @Autowired
    GradeService gradeService;

    @Test
    public void getGrade() {

    }

    @Test
    public void addGrade() {

    }

    @Test
    public void updateGrade() {
    }

    @Test
    public void deleteGrade() {
    }

    @Test
    public void listGrade() {
    }

    @Test
    public void calculateGrade() {
    }
}