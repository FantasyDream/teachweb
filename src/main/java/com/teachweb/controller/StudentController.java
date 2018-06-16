package com.teachweb.controller;

import com.teachweb.model.*;
import com.teachweb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @Autowired
    AnswerService answerService;

    @RequestMapping("/joinClass")
    public String joinClass(){
        return "student/joinClass";
    }

    @RequestMapping("/listClass")
    public String listClasss(Model model, HttpSession session){
        User user = (User) session.getAttribute("login");
        List<Classs> classsList = studentService.listClasss(user.getId());
        model.addAttribute("classsList",classsList);
        return "student/listClass";
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
        return "redirect:listClass";
    }

    @RequestMapping("/addAnswers")
    public String doSubjects(HttpServletRequest request,HttpSession session){
        User user = (User) session.getAttribute("login");
        Test test = (Test) session.getAttribute("test");
        String[] answers =request.getParameterValues("answer");
        studentService.addAnswers(test,answers,user.getId());
        return "redirect:listSubjectAction?testId="+test.getId();
    }

    @RequestMapping("/listTestAction")
    public String listTest(int classsId,HttpSession session,Model model){
        User user = (User) session.getAttribute("login");
        Classs classs = new Classs();
        classs.setId(classsId);
        classs = classsService.getClasss(classs);
        List<Test> tests = gradeService.listGradeByStudent(classsId);
        session.setAttribute("classs",classs);
        model.addAttribute("tests",tests);
        model.addAttribute("classs",classs);
        return "student/listTest";
    }

    @RequestMapping("/listSubjectAction")
    public String listSubjects(int testId,HttpSession session,Model model){
        User user = (User) session.getAttribute("login");
        Test test = new Test();
        test.setId(testId);
        test = testService.getTest(test);
        List<Subjects> subjects = testService.listSubject(testId);
        model.addAttribute("subjects",subjects);
        session.setAttribute("test",test);
        model.addAttribute("test",test);
        Grade grade = new Grade();
        grade.setTestid(testId);
        grade.setStudentid(user.getId());
        if ((grade=gradeService.getGrade(grade))!=null){
            model.addAttribute("grade",grade);
            model.addAttribute("answers",answerService.listAnswer(grade.getId()));
        }
        return "student/listSubject";
    }

    @RequestMapping("/listStudent")
    public String listStudent(int classsId,Model model){
        List<Student> students = classsService.listStudent(classsId);
        Classs classs = new Classs();
        classs.setId(classsId);
        classs = classsService.getClasss(classs);
        model.addAttribute("classs",classs);
        model.addAttribute("students",students);
        return "student/listStudent";
    }
}
