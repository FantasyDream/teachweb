package com.teachweb.controller;

import com.teachweb.model.User;
import com.teachweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(User user, HttpSession session){
        if(userService.exist(user)==false){
            ModelAndView modelAndView = new ModelAndView("loginfail");
            modelAndView.addObject("message","该手机号未注册!");
            return modelAndView;
        }
        if(userService.loginCheck(user)==true){
            session.setAttribute("login",user);
            ModelAndView modelAndView = new ModelAndView("loginsucc");
            modelAndView.addObject("message",user.getName()+",您已成功登陆");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("loginfail");
        modelAndView.addObject("message","用户名或密码不正确!");
        return modelAndView;
    }

    @RequestMapping("/register")
    public ModelAndView register(User user){
        if(userService.exist(user)==true){
            ModelAndView modelAndView = new ModelAndView("registerfail");
            modelAndView.addObject("errormes",user.getPhone()+"该手机号已注册");
            return modelAndView;
        }
        userService.register(user);
        ModelAndView modelAndView = new ModelAndView("registersucc");
        modelAndView.addObject("message",user.getName()+",您已注册成功!");
        return modelAndView;
    }

    @RequestMapping("/offline")
    public ModelAndView offline(User user,HttpSession session){
        session.invalidate();
        ModelAndView modelAndView=new ModelAndView("redirect:login.jsp");
        return modelAndView;
    }

    @RequestMapping("/userMessage")
    public String userMessage(){
        return "userMessage";
    }

    @RequestMapping("/updatePassword")
    public String updatePassword(){
        return "updatePassword";
    }

    @RequestMapping("/updatePasswordAction")
    public String updatePasswordAction(String oldPassword,String newPassword,HttpSession session){
        User login = (User)session.getAttribute("login");
        if(login.getPassword().equals(oldPassword)){
            login.setPassword(newPassword);
            userService.updatePassword(login);
        }
        return "userMessage";
    }

}
