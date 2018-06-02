package com.teachweb.service;

import com.teachweb.model.Parent;
import com.teachweb.model.Student;

import java.util.List;

public interface ParentService {

    void addParent(Parent parent);

    void deleteParent(Parent parent);

    Parent getParent(Parent parent);

    List<Parent> listParent();

    void updateParent(Parent parent);

    void addChildren(Parent parent, Student student);

    List<Student> listStudent(int parentId);
}
