package com.teachweb.controller;

import com.teachweb.model.*;
import com.teachweb.service.ClasssService;
import com.teachweb.service.GradeService;
import com.teachweb.service.StudentService;
import com.teachweb.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.rmi.runtime.NewThreadAction;
import sun.security.jgss.GSSCaller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    TestService testService;

    @Autowired
    ClasssService classsService;

    @Autowired
    GradeService gradeService;

    @RequestMapping("/listClasss")
    public String listClasss(Model model, HttpSession session){
        User user = (User) session.getAttribute("login");
        List<Classs> classsList = studentService.listClasss(user.getId());
        model.addAttribute("classsList",classsList);
        return "listClasss";
    }

    @RequestMapping("/joinClasssAction")
    public String joinClasss(String invitation, HttpSession session){
        System.out.println(invitation);
        User user = (User) session.getAttribute("login");
        Student student = new Student();
        student.setId(user.getId());
        try {
            studentService.joinClasss(student, invitation);
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "joinsucc";
    }

    @RequestMapping("/addAnswers")
    public String doSubjects(HttpServletRequest request,HttpSession session){
        User user = (User) session.getAttribute("login");
        Test test = (Test) session.getAttribute("test");
        String[] answers =request.getParameterValues("answer");
        studentService.addAnswers(test,answers,user.getId());
        return "addAnsersSucc";
    }

    @RequestMapping("/listTestAction")
    public String listTest(int classsId,HttpSession session,Model model){
        User user = (User) session.getAttribute("login");
        Classs classs = new Classs();
        classs.setId(classsId);
        classs = classsService.getClasss(classs);
        List<Test> tests = testService.listTest(classsId);
        model.addAttribute("tests",tests);
        model.addAttribute("classs",classs);
        return "listTest";
    }

    @RequestMapping("/listSubjectsAction")
    public String listSubjects(int testId,HttpSession session,Model model){
        User user = (User) session.getAttribute("login");
        Test test = new Test();
        test.setId(testId);
        test = testService.getTest(test);
        List<Subjects> subjects = testService.listSubject(testId);
        model.addAttribute("subjects",subjects);
        model.addAttribute("test",test);
        Grade grade = new Grade();
        grade.setTestid(testId);
        grade.setStudentid(user.getId());
        if (gradeService.getGrade(grade)!=null){
            List<Grade> grades= gradeService.listGrade(user.getId());
            model.addAttribute("grades",grades);
        }
        return "listSubjects";
    }
}
