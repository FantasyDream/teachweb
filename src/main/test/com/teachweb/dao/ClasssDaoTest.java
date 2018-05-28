package com.teachweb.dao;

import com.teachweb.model.Classs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class ClasssDaoTest {

    @Autowired
    ClasssDao classsDao;

    @Test
    public void addClasss() {
        Classs classs = new Classs();
        classs.setTeacherid(1);
        classs.setName("test");
        classs.setInvitation("12345678");
        classsDao.addClasss(classs);
    }
}