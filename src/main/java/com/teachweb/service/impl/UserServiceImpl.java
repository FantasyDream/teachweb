package com.teachweb.service.impl;

import com.teachweb.dao.ParentDao;
import com.teachweb.dao.StudentDao;
import com.teachweb.dao.TeacherDao;
import com.teachweb.model.Parent;
import com.teachweb.model.Student;
import com.teachweb.model.Teacher;
import com.teachweb.model.User;
import com.teachweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ParentDao parentDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    StudentDao studentDao;

    @Override
    public boolean register(User user) {
        switch (user.getType()){
            case "teacher":
                Teacher teacher = new Teacher();
                teacher.setPhone(user.getPhone());
                teacher.setName(user.getName());
                teacher.setPassword(user.getPassword());
                try {
                    teacherDao.addTeacher(teacher);
                }catch (Exception e){
                    e.printStackTrace();
                    return false;
                }
                break;
            case "student":
                Student student = new Student();
                student.setName(user.getName());
                student.setPhone(user.getPhone());
                student.setPassword(user.getPassword());
                try{
                    studentDao.addStudent(student);
                } catch (Exception e){
                    e.printStackTrace();
                    return false;
                }
                break;
            case "parent":
                Parent parent = new Parent();
                parent.setName(user.getName());
                parent.setPhone(user.getPhone());
                parent.setPassword(user.getPassword());
                try{
                    parentDao.addParent(parent);
                } catch (Exception e){
                    e.printStackTrace();
                    return false;
                }
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean loginCheck(User user) {
        switch (user.getType()){
            case "teacher":
                Teacher teacher = new Teacher();
                teacher.setPhone(user.getPhone());
                teacher.setPassword(user.getPassword());
                if(teacherDao.getTeacher(teacher)==null){
                    return false;
                }
                break;
            case "student":
                Student student = new Student();
                student.setPhone(user.getPhone());
                if (studentDao.getStudent(student)==null) {
                    return false;
                }
                break;
            case "parent":
                Parent parent = new Parent();
                parent.setPhone(user.getPhone());
                parent.setPassword(user.getPassword());
                if(parentDao.getParent(parent)==null){
                    return false;
                }
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean exist(User user) {
        switch (user.getType()){
            case "teacher":
                Teacher teacher = new Teacher();
                teacher.setPhone(user.getPhone());
                if(teacherDao.getTeacher(teacher)==null){
                    return false;
                }
                break;
            case "student":
                Student student = new Student();
                student.setPhone(user.getPhone());
                if (studentDao.getStudent(student)==null) {
                    return false;
                }
                break;
            case "parent":
                Parent parent = new Parent();
                parent.setPhone(user.getPhone());
                if(parentDao.getParent(parent)==null){
                    return false;
                }
                break;
            default:
                break;
        }
        return true;
    }

}
