package com.zyc.annotation.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    public void insertUser(){
        userService.insertUser();
    }
}