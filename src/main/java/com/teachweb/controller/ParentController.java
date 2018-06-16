package com.teachweb.controller;


import com.teachweb.model.*;
import com.teachweb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/parent")
@Controller
public class ParentController {

    @Autowired
    ParentService parentService;

    @Autowired
    StudentService studentService;

    @Autowired
    TestService testService;

    @Autowired
    ClasssService classsService;

    @Autowired
    GradeService gradeService;

    @RequestMapping("/listChrildren")
    public String listChrildren(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        List<Student> students = parentService.listStudent(user.getId());
        model.addAttribute("students",students);
        return "listChrildren";
    }

    @RequestMapping("/listClasss")
    public String listClasss(Model model,int studentId){
        List<Classs> studentClasss = studentService.listClasss(studentId);
        model.addAttribute("studentClasss",studentClasss);
        Student student = new Student();
        student.setId(studentId);
        student = studentService.getStudent(student);
        model.addAttribute("student",student);
        return "listClasss";
    }

    @RequestMapping("/listTest")
    public String listTest(Model model,int classsId,int studentId){
        List<Test> tests = testService.listTest(classsId);
        Student student = new Student();
        student.setId(studentId);
        student = studentService.getStudent(student);
        Classs classs = new Classs();
        classs.setId(classsId);
        classs = classsService.getClasss(classs);
        List<Grade> grades = new ArrayList<>();
        for(int i = 0;i<tests.size();i++){
            Grade grade = new Grade();
            grade.setStudentid(studentId);
            grade.setTestid(tests.get(i).getId());
            grades.add(grade);
        }
        model.addAttribute("student",student);
        model.addAttribute("tests",tests);
        model.addAttribute("grades",grades);
        return "teacher/listTest";
    }

    @RequestMapping("/listSubjects")
    public String listSubjects(int testId,Model model,int studentId){
        Test test = new Test();
        test.setId(testId);
        test = testService.getTest(test);
        List<Subjects> subjects = testService.listSubject(testId);
        model.addAttribute("subjects",subjects);
        model.addAttribute("test",test);
        Grade grade = new Grade();
        grade.setTestid(testId);
        grade.setStudentid(studentId);
        if (gradeService.getGrade(grade)!=null){
            List<Test> grades= gradeService.listGradeByStudent(studentId);
            model.addAttribute("grades",grades);
        }
        return "teacher/listSubject";
    }

}
