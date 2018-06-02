package com.teachweb.service.impl;

import com.teachweb.dao.ParentDao;
import com.teachweb.model.Parent;
import com.teachweb.model.Student;
import com.teachweb.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {

    @Autowired
    private ParentDao parentDao;

    @Override
    public void addParent(Parent parent) {
        parentDao.addParent(parent);
    }

    @Override
    public void deleteParent(Parent parent) {
        parentDao.deleteParent(parent);
    }

    @Override
    public Parent getParent(Parent parent) {
        return parentDao.getParent(parent);
    }

    @Override
    public List<Parent> listParent() {
        return parentDao.listParent();
    }

    @Override
    public void updateParent(Parent parent) {
        parentDao.updateParent(parent);
    }

    @Override
    public void addChildren(Parent parent, Student student) {
        parentDao.addChildren((int)parent.getId(), (int)student.getId());
    }

    @Override
    public List<Student> listStudent(int parentId) {
        return parentDao.listStudent(parentId);
    }

}
