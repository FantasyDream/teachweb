package com.teachweb.service.impl;

import com.teachweb.dao.ClasssDao;
import com.teachweb.model.Classs;
import com.teachweb.model.Student;
import com.teachweb.service.ClasssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasssServiceImpl implements ClasssService {

    @Autowired
    ClasssDao classsDao;

    @Override
    public void addClasss(Classs classs) {
        classsDao.addClasss(classs);
    }

    @Override
    public void deleteClasss(Classs classs) {
        classsDao.deleteClasss(classs);
    }

    @Override
    public void updateClasss(Classs classs) {
        classsDao.updateClasss(classs);
    }

    @Override
    public Classs getClasss(Classs classs) {
        return classsDao.getClasss(classs);
    }

    @Override
    public List<Classs> listClasss(int teacherid) {
        return classsDao.listClasss(teacherid);
    }

    @Override
    public List<Student> listStudent(int classsId) {
        return classsDao.listStudent(classsId);
    }

}
