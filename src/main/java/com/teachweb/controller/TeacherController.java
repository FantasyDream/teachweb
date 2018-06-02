package com.teachweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.teachweb.model.Classs;
import com.teachweb.model.Subjects;
import com.teachweb.model.Test;
import com.teachweb.model.User;
import com.teachweb.service.ClasssService;
import com.teachweb.service.SubjectsService;
import com.teachweb.service.TeacherService;
import com.teachweb.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

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

    @RequestMapping("/createClass")
    public String createClasss(Classs classs, HttpSession session){
        User user = (User) session.getAttribute("login");
        classs.setTeacherid(user.getId());
        try{
            classsService.addClasss(classs);
        } catch (Exception e){
            e.printStackTrace();
            return "createClassFail";
        }
        return "createClassSuccess";
    }

    @ResponseBody
    @RequestMapping("/getClassByJSON")
    public String getClassByJSON(int classid){
        Classs classs = new Classs();
        classs.setId(classid);
        classs = classsService.getClasss(classs);
        JSONObject json = new JSONObject();
        json.put("category",JSONObject.toJSON(classs));
        return json.toString();
    }

    @RequestMapping("/createTestAction")
    public String createTest(Test test, Model model, HttpSession session){
        int classid = ((Classs)session.getAttribute("classs")).getId();
        test.setClassid(classid);
        testService.addTest(test);
        session.setAttribute("test",test);
        return  "addTestSuccess";
    }

    @RequestMapping("/createSubjectsAction")
    public String addSubject(int range,int subject_no,int testId,HttpSession session,Model model){
        List<Subjects> subjectsList = subjectsService.createSubject(range,subject_no);
        Iterator<Subjects> iterator = subjectsList.iterator();
        Test test = new Test();
        test.setId(testId);
        test = testService.getTest(test);
        while(iterator.hasNext()){
            Subjects subjects = iterator.next();
            testService.addSubject(test,subjects);
        }
        model.addAttribute("test",test);
        model.addAttribute("subjectsList",subjectsList);
        return "subjectslist";
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
        model.addAttribute(classsList);
        return "listClassSuccess";
    }

    @RequestMapping("/getClasss")
    public String getClasss(int classid,Model model){
        Classs classs = new Classs();
        classs.setId(classid);
        classs = classsService.getClasss(classs);
        model.addAttribute("classs",classs);
        return "Classs";
    }

    @RequestMapping("/listTestAction")
    public String listTest(int classId,Model model){
        List<Test> tests = testService.listTest(classId);
        Classs classs = new Classs();
        classs.setId(classId);
        classs = classsService.getClasss(classs);
        model.addAttribute("classs",classs);
        model.addAttribute("tests",tests);
        return "listTest";
    }

    @RequestMapping("/listSubjectAction")
    public String listSubjects(int testId,Model model){
        List<Subjects> subjects =testService.listSubject(testId);
        Test test = new Test();
        test.setId(testId);
        test = testService.getTest(test);
        model.addAttribute("test",test);
        model.addAttribute("subjects",subjects);
        return "listSubject";
    }
}
