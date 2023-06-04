package com.tuturu.socialplaform.controller;


import com.tuturu.socialplaform.entity.User;
import com.tuturu.socialplaform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(UserService theUserService){
        userService=theUserService;
    }

    @GetMapping("/showRegisterForm")
    public String showRegisterForm(Model theModel) {
        User theUser=new User();
        theModel.addAttribute("user",theUser);
        return "/userView/register";
    }
    @GetMapping("/loginPage")
    public String showLoggingForm(Model theModel){
        User theUser=new User();
        theModel.addAttribute("user",theUser);
        return "/userView/login";
    }



    @PostMapping("/login")
    public String login(@ModelAttribute("user") User theUser, Model theModel ){

        User tempUser = userService.userLogin(theUser.getPhoneNumber(), theUser.getPassword());
        if (tempUser == null) {
            return "redirect:/userView/login";
        }
        return "main";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User theUser, BindingResult bindingResult){
        userService.save(theUser);
        return "main";
    }
    @GetMapping("/users")
    public List<User> fetchUsers(){
        return userService.findAll();
    }



}
