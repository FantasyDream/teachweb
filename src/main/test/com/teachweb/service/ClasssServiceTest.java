package com.teachweb.service;

import com.teachweb.model.Classs;
import com.teachweb.model.Student;
import com.teachweb.service.impl.ClasssServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class ClasssServiceTest {

    @Autowired
    ClasssService classsService;

    @Test
    public void addClasss() {
        Classs classs = new Classs();
        classs.setName("jmu");
        classs.setTeacherid(1);
        classs.setInvitation("jhksdfsd");
        if (classsService==null){
            System.out.println("666");
        }
        classsService.addClasss(classs);
    }

    @Test
    public void deleteClasss() {
        Classs classs = new Classs();
        classs.setId(2);
        classsService.deleteClasss(classs);
    }

    @Test
    public void updateClasss() {
        Classs classs = new Classs();
        classs.setId(1);
        classs.setName("jmutest");
        classsService.updateClasss(classs);
    }

    @Test
    public void getClasss() {
        Classs classs = new Classs();
        classs.setName("jmutest");
        classs = classsService.getClasss(classs);
        System.out.println(classs.getId());
    }

    @Test
    public void listClasss() {
        List<Classs> list = classsService.listClasss(1);
        Iterator<Classs> iterator = list.iterator();
        while(iterator.hasNext()){
            Classs classs = iterator.next();
            System.out.println(classs.getId());
        }
    }

    @Test
    public void listStudent() {
        List<Student> students = classsService.listStudent(1);
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()){
            Student student= iterator.next();
            System.out.println(student.getId());
        }
    }
}