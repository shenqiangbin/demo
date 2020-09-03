package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/")
    public String index(){
        return "welcome";
    }

    @ResponseBody
    @GetMapping("/test")
    public void test() throws SQLException {
        userService.test();
    }
}
