package com.teachweb.service;

import com.teachweb.model.Parent;
import com.teachweb.model.Student;
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
public class ParentServiceTest {

    @Autowired
    ParentService parentService;

    @Test
    public void addParent() {
        Parent parent = new Parent();
        parent.setPhone("11111111111");
        parent.setPassword("123456");
        parent.setName("linda");
        parentService.addParent(parent);
    }

    @Test
    public void deleteParent() {
        Parent parent = new Parent();
        parent.setPhone("11111111111");
        parent.setPassword("123456");
        parentService.deleteParent(parentService.getParent(parent));
    }

    @Test
    public void getParent() {
        Parent parent = new Parent();
        parent.setPhone("11111111111");
        parent.setPassword("123456");
        System.out.println(parentService.getParent(parent));
    }

    @Test
    public void listParent() {
        List<Parent> parents = parentService.listParent();
        Iterator<Parent> iterator = parents.iterator();
        while(iterator.hasNext()){
            Parent parent= iterator.next();
            System.out.println(parent.getId());
        }
    }

    @Test
    public void updateParent() {
        Parent parent = new Parent();
        parent.setPhone("11111111111");
        parent.setId(1);
        parent.setName("Tom");
        parentService.updateParent(parent);
    }

    @Test
    public void addChildren() {
        Student student = new Student();
        student.setId(11);
        Parent parent = new Parent();
        parent.setId(2);
        parentService.addChildren(parent,student);
    }
}