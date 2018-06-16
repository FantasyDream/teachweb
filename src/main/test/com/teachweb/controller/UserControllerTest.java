package com.teachweb.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class UserControllerTest {

    private MockHttpServletRequest request;

    private MockHttpServletResponse response;

    private MockHttpSession session;

    @Autowired
    private UserController userController;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        this.session = new MockHttpSession();
        this.request = new MockHttpServletRequest();
        this.response = new MockHttpServletResponse();
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        request.setCharacterEncoding("UTF-8");
    }

    @Test
    public void login() {

    }

    @Test
    public void register() {
    }

    @Test
    public void offline() {
    }
}