package com.example.cs.controller;

import com.example.cs.entity.Invitation;
import com.example.cs.entity.User;
import com.example.cs.service.InvitationService;
import com.example.cs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private InvitationService invitationService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/loginUser")
    public String login(Model model, User user){
        String url = "index";
        //1.根据账号密码查询用户
        User us = new User();
        try {
            us = userService.query(user.getUserName(),user.getPassword());
        }catch (Exception e){
            e.printStackTrace();
         }

        //2.判断用户是否存在，存在-登录成功，跳转到首页 ， 不存在 ，登录失败
        if(us==null){
            return "用户不存在！";
        }
        if(us.getRole().equals("admin") || us.getRole().equals("root")){
            url = "index_login_root";
        }else {
            url = "index_login";
        }
        model.addAttribute("userName",user.getUserName());
        model.addAttribute("role",us.getRole());
        model.addAttribute("id",us.getId());
        model.addAttribute("user",user);
        List<Invitation> invitationList =  invitationService.findAll();
        model.addAttribute("invitationList", invitationList);
        return url;
    }

    @RequestMapping("/toUser")
    public String toUser(Model model,HttpServletRequest request){
        String userName = request.getParameter("userName");
        String id = request.getParameter("id");
        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);
        model.addAttribute("userName",userName);
        model.addAttribute("id",id);
        return "user";
    }

    @RequestMapping("/goaddUser")
    public String goaddUser(){
        return "register";
    }

    /**
     * 用户查询
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/goqueryUser")
    public String goqueryUser(Model model, HttpServletRequest request){
        //获取帖子标题（查询条件）
        String userName = request.getParameter("userName");
        String id = request.getParameter("id");
        List<User> userList= new ArrayList<>();
        if (userName == null) {
            userList = userService.findAll();
        }else{
            userList = userService.findAllByUserNameLike(userName);
        }

        model.addAttribute("userList",userList);
        model.addAttribute("userName",userName);
        model.addAttribute("id",id);
        return "user";
    }


    @PostMapping("/saveUser")
    public String saveUser(User user){
        userService.save(user);
        return "login";
    }

    @RequestMapping("/godelUser")
    public String deleteById(Model model,HttpServletRequest request){
        String id = request.getParameter("id");
        String userName = request.getParameter("userName");
        userService.delete(Integer.parseInt(id));
        List<User> userList =  userService.findAll();
        model.addAttribute("userList", userList);
        model.addAttribute("userName",userName);
        return "user";
    }

    /**
     * 修改用户信息
     * @return
     */
    @RequestMapping("/goupdateUser")
    public String update(Model model, HttpServletRequest request){
        String id = request.getParameter("id");
        String userName = request.getParameter("userName");
        User user =  userService.findById(Integer.parseInt(id));
        model.addAttribute("user",user);
        model.addAttribute("userName",userName);
        return "editUser";
    }



}
