package com.teachweb.service;

import com.teachweb.model.User;
import com.teachweb.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void registerTest() {
        User user = new User();
        user.setType("teacher");
        user.setName("古一");
        user.setPassword("123456");
        user.setPhone("15551391887");
        userService.register(user);
    }

    @Test
    public void loginCheck() {
        User user = new User();
        user.setType("teacher");
        user.setPhone("15551391887");
        user.setPassword("123456");
        boolean b = userService.loginCheck(user);
        System.out.println(b);
    }

    @Test
    public void existCheck(){
        User user = new User();
        user.setType("student");
        user.setPhone("15551391886");
        user.setPassword("123456");
        user.setName("int");
        boolean b = userService.loginCheck(user);
        System.out.println(b);
    }
}