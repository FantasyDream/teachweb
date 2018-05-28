package com.teachweb.service;

import com.teachweb.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class StudentServiceTest {

    @Autowired
    StudentService studentService;
    @Test
    public void addStudent() {
        for (int i = 0; i <10 ; i++) {
            Student student = new Student();
            student.setName("学生"+i);
            student.setPhone("1555555556"+i);
            student.setPassword("123456");
            studentService.addStudent(student);
        }
    }

    @Test
    public void deleteStudent() {
        for (int i = 0; i <10 ; i++) {
            Student student = new Student();
            student.setId(i+1);
            studentService.deleteStudent(student);
        }
    }

    @Test
    public void getStudent() {
        Student student = new Student();
        student.setPhone("15555555558");
        student = studentService.getStudent(student);
        System.out.println(student.getId());
    }

    @Test
    public void listStudent() {
        List<Student> students = studentService.listStudent();
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()){
            Student student = iterator.next();
            System.out.println(student.getId());
        }
    }

    @Test
    public void updateStudent() {
        Student student = new Student();
        student.setId(11);
        student.setPhone("15566336677");
        studentService.updateStudent(student);
    }

    @Test
    public void joinClasss() {
        Student student = new Student();
        student.setId(13);
        studentService.joinClasss(student,"jhksdfsd");
    }

}