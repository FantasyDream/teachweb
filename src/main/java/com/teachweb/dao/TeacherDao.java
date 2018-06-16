package com.teachweb.dao;

import com.teachweb.model.Classs;
import com.teachweb.model.Teacher;

import java.util.List;

public interface TeacherDao {

    int addTeacher(Teacher teacher);

    void deleteTeacher(Teacher teacher);

    Teacher getTeacher(Teacher teacher);

    List<Teacher> listTeacher();

    void updateTeacher(Teacher teacher);

    List<Classs> listClasss(int teacherId);
}
