package com.teachweb.dao;

import com.teachweb.model.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class TeacherDaoTest {

    @Autowired
    private TeacherDao dao;

    @Test
    public void addTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName("张三");
        teacher.setPassword("123456");
        teacher.setPhone("15356846611");
        dao.addTeacher(teacher);
    }

    @Test
    public void deleteTeacher(){
        Teacher teacher = new Teacher();
        teacher.setName("张文");
        teacher.setId(7);
        teacher.setPassword("123456");
        teacher.setPhone("15356846611");
        dao.deleteTeacher(teacher);
    }

    @Test
    public void updateTest(){
        Teacher teacher = new Teacher();
        teacher.setName("张文");
        teacher.setId(5);
        teacher.setPassword("123456");
        teacher.setPhone("15354544545");
        dao.updateTeacher(teacher);
    }

    @Test
    public void getTest() {
        Teacher teacher = new Teacher();
        teacher.setPhone("15255667799");
        teacher.setPassword("123456");
        System.out.println(dao.getTeacher(teacher));
    }

    @Test
    public void listTest() {
        List<Teacher> teachers = dao.listTeacher();
        for(Teacher teacher:teachers){
            System.out.println(teacher.getName());
        }
    }
}
