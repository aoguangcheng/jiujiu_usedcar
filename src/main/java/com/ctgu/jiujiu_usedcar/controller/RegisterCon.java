package com.ctgu.jiujiu_usedcar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterCon {

    @RequestMapping("toregisterPage")
    public String toregisterPage()
    {
        return "registerPage";
    }

    @RequestMapping("homePage")
    public String tohomePage(){
        return "homePage";
    }
}
