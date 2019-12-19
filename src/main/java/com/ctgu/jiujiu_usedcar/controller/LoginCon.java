package com.ctgu.jiujiu_usedcar.controller;

import com.ctgu.jiujiu_usedcar.config.RandomStringUtil;
import com.ctgu.jiujiu_usedcar.dao.UserDao;
import com.ctgu.jiujiu_usedcar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginCon {

    @Autowired
    UserDao userDao;

    String VerificationCode;

    //生成验证码
    public void generateVerficationCode(Model model)
    {
        VerificationCode = RandomStringUtil.getRandomString(4);
        model.addAttribute("VerificationCode",VerificationCode);
    }

    @RequestMapping("tologinPage")
    public String toLoginPage(Model model){
        this.generateVerficationCode(model);
        return "loginPage";
    }

    @RequestMapping("submitInfo")
    public String submitInfo(@RequestParam("telenum") String telenum,
                             @RequestParam("password") String password,
                             @RequestParam("SubmitVerificationCode") String SubmitVerificationCode,
                             Model model,
                             HttpSession session){
        if(this.VerificationCode.equals(SubmitVerificationCode))
        {
            //验证码正确
            System.out.println("验证码正确");
            System.out.println("当前验证码为："+ this.VerificationCode);
            System.out.println("当前提交的验证码为：" + SubmitVerificationCode);
            List<User> userList = userDao.findByTelenum(telenum);
            if(userList.size() != 0)
            {
                System.out.println("用户已注册");
                System.out.println("当前验证码为："+ this.VerificationCode);
                System.out.println("当前提交的验证码为：" + SubmitVerificationCode);
                //该用户已注册过
                if(userList.get(0).getPassword().equals(password))
                {
                    //密码正确
                    if(userList.get(0).getInfoIntegrity() >= 80)
                    {
                        //该用户信息完整度大于80，跳转到主界面homepage
                        session.setAttribute("user",userList.get(0));
                        return "homepage";
                    }
                    else {
                        //用户信息小于80，提示到个人信息界面补充信息
                    /*
                    * 进行后续操作*/
                        return "homepage";
                    }
                }
                else {
                    //密码错误
                    System.out.println("密码错误");
                    this.generateVerficationCode(model);
                    model.addAttribute("VerificationCode",this.VerificationCode);
                    model.addAttribute("tips", "密码错误");
                    System.out.println("当前验证码为："+ this.VerificationCode);
                    System.out.println("当前提交的验证码为：" + SubmitVerificationCode);
                    return "loginPage";
                }
            }
            else {
                //该用户未注册，进行注册
                System.out.println("用户未注册");
                System.out.println("当前验证码为："+ this.VerificationCode);
                System.out.println("当前提交的验证码为：" + SubmitVerificationCode);
                User user = new User();
                user.setTelenum(telenum);
                user.setPassword(password);
                user.setInfoIntegrity(20);
                //userDao.save(user);
                model.addAttribute("tips","未注册");
                return "loginPage";
            }
        }
        else {
            System.out.println("验证码不正确");
            System.out.println("当前验证码为："+ this.VerificationCode);
            System.out.println("当前提交的验证码为：" + SubmitVerificationCode);
            //验证码不正确
            model.addAttribute("telenum",telenum);
            model.addAttribute("password",password);
            this.generateVerficationCode(model);
            model.addAttribute("VerificationCode",this.VerificationCode);
            model.addAttribute("tips","验证码不正确");
            return "loginPage";
        }
    }
}
