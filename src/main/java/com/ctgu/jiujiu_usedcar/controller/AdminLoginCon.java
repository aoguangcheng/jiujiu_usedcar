package com.ctgu.jiujiu_usedcar.controller;

import com.ctgu.jiujiu_usedcar.dao.AdminInfoDao;
import com.ctgu.jiujiu_usedcar.entity.AdminInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminLoginCon {

    @Autowired
    AdminInfoDao admininfoDao;


    @RequestMapping({"/index", "/"})
    public String toLoginPage()
    {
        return "adminLogin";
    }


    @RequestMapping("/tologin")
    public String login(@RequestParam("adminName") String adminName,
                        @RequestParam("adminPassword") String adminPassword) {
        List<AdminInfo> adminInfos = admininfoDao.findByAdminNameAndAdminPassword(adminName, adminPassword);
        if(adminInfos.size() >= 1)
        {
            return "homepage";
        }
        else {
            return "adminLogin";
        }
    }

    @RequestMapping("/login")
    public  String ts(){
        return "homepage";
    }

}
