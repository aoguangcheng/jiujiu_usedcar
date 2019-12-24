package com.ctgu.jiujiu_usedcar.controller;

import com.ctgu.jiujiu_usedcar.config.RandomStringUtil;
import com.ctgu.jiujiu_usedcar.dao.UserDao;
import com.ctgu.jiujiu_usedcar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class RegisterCon {
    /**上传地址*/
    @Value("${file.upload.path}")
    private String filePath;

    @Autowired
    UserDao userDao;

    @RequestMapping("toregisterPage")
    public String toregisterPage()
    {
        return "login/registerPage";
    }

    @RequestMapping("homePage")
    public String tohomePage(){
        return "redirect:/home";
    }

    @RequestMapping("toregister")
    public String register(@RequestParam("telenum") String telenum,
                           @RequestParam("password") String password,
                           @RequestParam("passwordrepeat") String passwordrepeat,
                           @RequestParam("nickname") String nickname,
                           @RequestParam("headicon") MultipartFile file,
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
        user.setBalance("0");
        user.setInfoIntegrity(88);
        user.setDormitory(dormitory+build + "#");
        // 获取上传文件名
        String oldfilename = file.getOriginalFilename();
        System.out.println("初始的文件名"+oldfilename);
        String filename = (new RandomStringUtil().getRandomString(18)) +"-"+ oldfilename;

        System.out.println("添加随机字符串后的文件名：" + filename);
        // 定义上传文件保存路径
        String path = filePath+"rotPhoto/";
        // 新建文件
        File filepath = new File(path, filename);
        // 判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        try {
            // 写入文件
            file.transferTo(new File(path + File.separator + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setHeadicon("/images/rotPhoto/"+filename);

        System.out.println(user.toString());
        userDao.save(user);
        session.setAttribute("user",user);
        model.addAttribute("userStatus","已登录");
        return "redirect:/home";
    }
}
