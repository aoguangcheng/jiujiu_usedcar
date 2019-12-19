package com.ctgu.jiujiu_usedcar.controller;

import com.ctgu.jiujiu_usedcar.dao.UserDao;
import com.ctgu.jiujiu_usedcar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterCon {

    @Autowired
    UserDao userDao;

    @RequestMapping("toregisterPage")
    public String toregisterPage()
    {
        return "registerPage";
    }

    @RequestMapping("homePage")
    public String tohomePage(){
        return "homePage";
    }

    @RequestMapping("toregister")
    public String register(@RequestParam("telenum") String telenum,
                           @RequestParam("password") String password,
                           @RequestParam("passwordrepeat") String passwordrepeat,
                           @RequestParam("nickname") String nickname,
                           @RequestParam("sex") String sex,
                           @RequestParam("birthday") String birthday,
                           @RequestParam("province") String province,
                           @RequestParam("city") String city,
                           @RequestParam("grade") String grade,
                           @RequestParam("college") String college,
                           @RequestParam("major") String major,
                           //@RequestParam("hobby") List<String> hobby,
                           @RequestParam("dormitory") String dormitory,
                           @RequestParam("build") String build,
                           Model model,
                           HttpSession session) throws  Exception{
        User user = new User();
        user.setTelenum(telenum);
        user.setPassword(password);
        user.setNickname(nickname);
        user.setSex(sex);
        user.setBirthday(birthday);
        user.setDwells(province+city);
        user.setGrade(grade);
        user.setCollege(college);
        user.setMajor(major);
        //user.setHobby(hobby.get(0));
        user.setDormitory(dormitory+build + "#");
        System.out.println(user.toString());
        userDao.save(user);
        session.setAttribute("user",user);
        model.addAttribute("userStatus","已登录");
        return "homepage";
    }
}
