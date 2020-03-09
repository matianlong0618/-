package com.baomidou.mybatisplus.samples.generator.controller;


import com.baomidou.mybatisplus.samples.generator.entity.Users;
import com.baomidou.mybatisplus.samples.generator.mapper.UsersMapper;
import com.baomidou.mybatisplus.samples.generator.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ML
 * @since 2020-03-08
 */
@Controller
@RequestMapping
public class UsersController {


    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public List<Users> findAll() {
        return usersService.findAll();
    }

    @PostMapping("/users")
    public boolean addUser(Users users) {
        return usersService.addUser(users);
    }

    @GetMapping("/users/{id}")
    public Users get(@PathVariable("id") long id) {
        return usersService.findById(id);
    }

    @DeleteMapping("/users")
    public boolean deleteAll(Users users){
        return usersService.deleteAll(users);
    }

    @DeleteMapping("/users/{id}")
    public boolean get(@PathVariable("id") Users users){
        return usersService.deleteById(users);
    }

    @DeleteMapping( "/users/{id1,id2,...}")
    public String deleteMore(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        String msg = "";
        usersService.deleteMore(id);
        msg = "1";    //成功
        return msg;
    }
    @PostMapping("/users/{id}")
    public Users setById(Users users){
        return usersService.setById(users);
    }

    @PostMapping("/users/reset/password")
    public Users updatePassword(Users users){
        return usersService.updatePassword(users);
    }

    @PostMapping("/users/login")
    public ModelAndView login(String name, String password, ModelAndView mv, HttpSession session) {
        Users users=usersService.login(name, password);
        if(users!=null){
            //登录成功，将user对象设置到HttpSession作用范围域中
            session.setAttribute("user", users);
            //登录成功，跳转页面　
            mv.setViewName("mainPage");
        }else {
            //登录失败，设置失败信息，并调转到登录页面
            mv.addObject("message","登录名和密码错误，请重新输入");
            // 登录失败，跳转页面
            mv.setViewName("error");
        }
        return mv;
    }
}
