package com.teachweb.service.impl;

import com.teachweb.dao.TeacherDao;
import com.teachweb.model.Classs;
import com.teachweb.model.Teacher;
import com.teachweb.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherDao.deleteTeacher(teacher);
    }

    @Override
    public Teacher getTeacher(Teacher teacher) {
        return teacherDao.getTeacher(teacher);
    }

    @Override
    public List<Teacher> listTeacher() {
        return teacherDao.listTeacher();
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);
    }

    @Override
    public List<Classs> listClasss(int teacherId) {
        return teacherDao.listClasss(teacherId);
    }
}
