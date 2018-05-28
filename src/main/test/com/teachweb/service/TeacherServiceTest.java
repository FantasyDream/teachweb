package com.teachweb.service;

import com.teachweb.model.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class TeacherServiceTest {

    @Autowired
    TeacherService teacherService;

    @Test
    public void addTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName("张三");
        teacher.setPassword("123456");
        teacher.setPhone("15256846611");
        teacherService.addTeacher(teacher);
    }

    @Test
    public void deleteTeacher(){
        Teacher teacher = new Teacher();
        teacher.setName("张文");
        teacher.setId(7);
        teacher.setPassword("123456");
        teacher.setPhone("15256846611");
        teacherService.deleteTeacher(teacher);
    }

    @Test
    public void updateTest(){
        Teacher teacher = new Teacher();
        teacher.setName("张文");
        teacher.setId(5);
        teacher.setPassword("123456");
        teacher.setPhone("15254544545");
        teacherService.updateTeacher(teacher);
    }

    @Test
    public void getTest() {
        Teacher teacher = new Teacher();
        teacher.setPhone("15255667788");
        teacher.setPassword("123456");
        System.out.println(teacherService.getTeacher(teacher).getName());
    }

    @Test
    public void listTest() {
        List<Teacher> teachers = teacherService.listTeacher();
        for(Teacher teacher:teachers){
            System.out.println(teacher.getName());
        }
    }
}
