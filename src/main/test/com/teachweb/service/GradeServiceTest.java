package com.teachweb.service;

import com.teachweb.model.Grade;
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
public class GradeServiceTest {

    @Autowired
    GradeService gradeService;

    @Test
    public void getGrade() {
        Grade grade = new Grade();
        grade.setId(2);
        System.out.println(gradeService.getGrade(grade).getGrade());
    }

    @Test
    public void addGrade() {
        Grade grade = new Grade();
        grade.setTestid(2);
        grade.setStudentid(11);
        gradeService.addGrade(grade);
    }

    @Test
    public void updateGrade() {
        Grade grade = new Grade();
        grade.setId(1);
        grade.setGrade(60);
        gradeService.updateGrade(grade);
    }

    @Test
    public void deleteGrade() {
        Grade grade = new Grade();
        grade.setId(1);
        gradeService.deleteGrade(grade);
    }

    @Test
    public void listGrade() {
        List<com.teachweb.model.Test> grades = gradeService.listGradeByStudent(1);
        System.out.println(grades.size());
        Iterator<com.teachweb.model.Test> iterator = grades.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getGrade());
        }
    }

    @Test
    public void calculateGrade() {
        Grade grade = new Grade();
        grade.setId(2);
        grade = gradeService.getGrade(grade);
        gradeService.calculateGrade(grade);
        grade = gradeService.getGrade(grade);
        System.out.println(grade.getGrade());
    }
}