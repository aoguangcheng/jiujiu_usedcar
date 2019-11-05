package com.ctgu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class login {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return  "Hello, World!!";
    }
}