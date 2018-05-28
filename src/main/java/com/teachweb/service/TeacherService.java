package com.teachweb.service;

import com.teachweb.model.Classs;
import com.teachweb.model.Teacher;

import java.util.List;

public interface TeacherService {

    void addTeacher(Teacher teacher);

    void deleteTeacher(Teacher teacher);

    Teacher getTeacher(Teacher teacher);

    List<Teacher> listTeacher();

    void updateTeacher(Teacher teacher);

    List<Classs> listClasss(int teacherId);
}
