package com.teachweb.dao;

import com.teachweb.model.Parent;

import java.util.List;

public interface ParentDao {

    void addParent(Parent parent);

    void deleteParent(Parent parent);

    Parent getParent(Parent parent);

    List<Parent> listParent();

    void updateParent(Parent parent);

    void addChildren(int parentId,int studentId);
}
