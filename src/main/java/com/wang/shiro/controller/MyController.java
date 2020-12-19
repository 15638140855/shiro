package com.wang.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @RequestMapping({"/", "/index"})
    public String toString(Model model) {
        model.addAttribute("msg", "msg");
        return "index";
    }

    @RequestMapping("user/add")
    public String toString1(Model model) {
        model.addAttribute("msg", "msg");
        return "user/add";
    }

    @RequestMapping("user/upd")
    public String toString2(Model model) {
        model.addAttribute("msg", "msg");
        return "user/upd";
    }

    @RequestMapping("/tologin")
    public String toString3(Model model) {
        return "login";
    }

    @RequestMapping("/login")
    public String toString4(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);//执行登录的方法。没有异常就ok
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名错误");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }
    /*未授权*/
    @RequestMapping("/noauth")
    @ResponseBody
    public String toString5(Model model) {
        return "未授权，无法访问此页面";
    }

}
