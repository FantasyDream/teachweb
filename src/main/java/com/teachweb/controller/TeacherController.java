package com.teachweb.controller;

import com.teachweb.model.*;
import com.teachweb.service.*;
import com.teachweb.utils.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    ClasssService classsService;

    @Autowired
    TestService testService;

    @Autowired
    SubjectsService subjectsService;

    @Autowired
    GradeService gradeService;

    @RequestMapping("/createClass")
    public String createClasss(){
        return "teacher/createClass";
    }

    @RequestMapping("/submitNumber")
    public String createSubject(){ return "teacher/submitNumber";}

    @RequestMapping("/createTest")
    public String createTest(int classId,Model model){
        Classs classs = new Classs();
        classs.setId(classId);
        classs = classsService.getClasss(classs);
        model.addAttribute("classs",classs);
        return "teacher/createTest";
    }

    @RequestMapping("/createClassAction")
    public String createClasssAction(String classsName, HttpSession session,Model model){
        User user = (User) session.getAttribute("login");
        Classs classs = new Classs();
        while(true){
            String invitation = Method.randomString(8);
            classs.setInvitation(invitation);
            if(classsService.getClasss(classs)==null){
                break;
            }
        }
        classs.setName(classsName);
        classs.setTeacherid(user.getId());
        System.out.println(user.getId());
        try{
            classsService.addClasss(classs);
        } catch (Exception e){
            e.printStackTrace();
            model.addAttribute("message","创建班级失败！");
            return "error";
        }
        return "redirect:listClass";
    }

    @RequestMapping("/createSubject")
    public String submitNumber(int num,Model model){
        model.addAttribute("num",num);
        return "teacher/createSubjects";
    }

    @RequestMapping("/createSubjectAction")
    public String createSubjectAction(HttpServletRequest request, Model model){
        String[] subjects = request.getParameterValues("subject");
        String[] answers = request.getParameterValues("answer");
        for (int i=0;i<subjects.length;i++){
            Subjects subjects1 = new Subjects();
            subjects1.setExpression(subjects[i]);
            subjects1.setAnswer(answers[i]);
            subjectsService.addSubjects(subjects1);
        }
        model.addAttribute("message","已成功提交题目");
        return "success";
    }

    @Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
    @RequestMapping("/createTestAction")
    public String createTest(int subject_no,String testName, Model model, HttpSession session){
        int range=10;
        int classid = ((Classs)session.getAttribute("classs")).getId();
        Test test = new Test();
        test.setName(testName);
        test.setClassid(classid);
        testService.addTest(test);
        List<Subjects> subjectsList = subjectsService.createSubject(range,subject_no);
        Iterator<Subjects> iterator = subjectsList.iterator();
        test = testService.getTest(test);
        while(iterator.hasNext()){
            Subjects subjects = iterator.next();
            testService.addSubject(test,subjects);
        }
        model.addAttribute("test",test);
        return  "redirect:listTestAction?classId="+classid;
    }


    @RequestMapping("createTestAction1")
    public String createTestA(int type,int subject_no,String testName, Model model, HttpSession session){
        if(type == 1){
            int range=10;
            int classid = ((Classs)session.getAttribute("classs")).getId();
            Test test = new Test();
            test.setName(testName);
            test.setClassid(classid);
            testService.addTest(test);
            List<Subjects> subjectsList = subjectsService.createSubject(range,subject_no);
            Iterator<Subjects> iterator = subjectsList.iterator();
            test = testService.getTest(test);
            while(iterator.hasNext()){
                Subjects subjects = iterator.next();
                testService.addSubject(test,subjects);
            }
            model.addAttribute("test",test);
            return  "redirect:listTestAction?classId="+classid;
        } else {
            int classid = ((Classs)session.getAttribute("classs")).getId();
            Test test = new Test();
            test.setName(testName);
            test.setClassid(classid);
            testService.addTest(test);
            Random random = new Random();
            return  "redirect:listTestAction?classId="+classid;
        }
    }

    @RequestMapping("/listClass")
    public String listClasss(HttpSession httpSession, Model model){
        User user = (User) httpSession.getAttribute("login");
        List<Classs> classsList = null;
        try{
            classsList = teacherService.listClasss(user.getId());
        } catch (Exception e){
            e.printStackTrace();
            return "listClassFail";
        }
        System.out.println(classsList.size());
        model.addAttribute("classList",classsList);
        return "teacher/listClass";
    }

    @RequestMapping("/listTestAction")
    public String listTest(int classId,Model model,HttpSession session){
        List<Test> tests = testService.listTest(classId);
        Classs classs = new Classs();
        classs.setId(classId);
        classs = classsService.getClasss(classs);
        session.setAttribute("classs",classs);
        model.addAttribute("tests",tests);
        return "teacher/listTest";
    }

    @RequestMapping("/listStudent")
    public String listStudent(int classId,Model model){
        List<Student> students = classsService.listStudent(classId);
        Classs classs = new Classs();
        classs.setId(classId);
        classs = classsService.getClasss(classs);
        model.addAttribute("students",students);
        return "teacher/listStudent";
    }

    @RequestMapping("/listSubjectAction")
    public String listSubjects(int testId,Model model){
        List<Subjects> subjects =testService.listSubject(testId);
        Test test = new Test();
        test.setId(testId);
        test = testService.getTest(test);
        model.addAttribute("test",test);
        model.addAttribute("subjects",subjects);
        return "teacher/listSubject";
    }

    @RequestMapping("/listStudentGrade")
    public String listStudentGrade(int testId,Model model){
        List<Student> students = gradeService.listGradeByTest(testId);
        Test test = new Test();
        test.setId(testId);
        test = testService.getTest(test);
        model.addAttribute("test",test);
        model.addAttribute("students",students);
        return "teacher/listStudentGrade";
    }
}
