package com.ctgu.jiujiu_usedcar.controller;

import com.ctgu.jiujiu_usedcar.config.RandomStringUtil;
import com.ctgu.jiujiu_usedcar.dao.GoodsDao;
import com.ctgu.jiujiu_usedcar.dao.UserDao;
import com.ctgu.jiujiu_usedcar.entity.Goods;
import com.ctgu.jiujiu_usedcar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginCon {

    @Autowired
    UserDao userDao;

    @Autowired
    GoodsDao goodsDao;

    String VerificationCode;

    //生成验证码
    public void generateVerficationCode(Model model)
    {
        VerificationCode = RandomStringUtil.getRandomString(4);
        model.addAttribute("VerificationCode",VerificationCode);
    }
    //主界面
    @RequestMapping("/home")
    public String tohomePage(Model model)
    {
        List<Goods> goods = goodsDao.findAllByState(1);
        model.addAttribute("goodsList",goods);
//        model.addAttribute("user",userDao.findByTelenum("admin").get(0));
        model.addAttribute("userStatus","未登录");
        return "login/homepage";
    }

    @RequestMapping("/homepage")
    public String homePage(Model model)
    {
        List<Goods> goods = goodsDao.findAllByState(1);
        model.addAttribute("goodsList",goods);
//        model.addAttribute("user",userDao.findByTelenum("admin").get(0));
        model.addAttribute("userStatus","未登录");
        return "homepage";
    }
    //跳转到登录界面
    @RequestMapping("tologinPage")
    public String toLoginPage(Model model){
        this.generateVerficationCode(model);
        return "login/loginPage";
    }
    //退出登录
    @RequestMapping("tologinout")
    public String tologinout(HttpSession session,Model model){
        session.removeAttribute("user");
        model.addAttribute("userStatus","未登录");
        return "redirect:/home";
    }
//在登录界面验证登录
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
                    System.out.println(userList.get(0).toString());
                    System.out.println("密码正确");
                    if(userList.get(0).getInfoIntegrity() >= 80)
                    {
                        //该用户信息完整度大于80，跳转到主界面homepage
                        System.out.println("信息完整");
                        session.setAttribute("user",userList.get(0));
                        model.addAttribute("userStatus", "已登录");
                        return "redirect:/home";
                    }
                    else {
                        //用户信息小于80，提示到个人信息界面补充信息
                    /*
                    * 进行后续操作*/
                        System.out.println("信息不完整");
                        session.setAttribute("user",userList.get(0));
                        model.addAttribute("userStatus", "已登录");
                            return "redirect:/home";
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
                    return "login/loginPage";
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
                return "login/loginPage";
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
            return "login/loginPage";
        }
    }


    @RequestMapping("queryUerOrGoods")
    public String queryUerOrGoods(@RequestParam("userOrGoods") String userOrGoods,
                                  @RequestParam("summary_classifyname") String summary_classifyname,
                                  @RequestParam("detail_classifyname") String detail_classifyname,
                                  @RequestParam("key") String key,
                                  Model model){
        System.out.println(userOrGoods);
        System.out.println(summary_classifyname);
        System.out.println(detail_classifyname);
        System.out.println(key);
        List<Goods> goodsList = new ArrayList<Goods>();
        List<User> userList = new ArrayList<User>();
//        查询物品 goodsList
        if (userOrGoods.equals("物品"))
        {
            if(key.equals("物品")){
                if(summary_classifyname.equals("请选择分类"))
                {
                    if (detail_classifyname.equals("请选择分类"))
                    {
                        goodsList = goodsDao.findAllByState(1);
                    }
                    else {
                        goodsList = goodsDao.findByStateAndDetailClassifynameLike(1,"%"+detail_classifyname+"%");
                    }
                }
                else {
                    if (detail_classifyname.equals("请选择分类"))
                    {
                        goodsList = goodsDao.findByStateAndSummaryClassifynameLike(1,"%"+summary_classifyname+"%");
                    }
                    else {
                        goodsList = goodsDao.findByStateAndSummaryClassifynameLikeAndDetailClassifynameLike(1,"%"+summary_classifyname+"%","%"+detail_classifyname+"%");
                    }
                }
            }
            else {
                if(summary_classifyname.equals("请选择分类"))
                {
                    if (detail_classifyname.equals("请选择分类"))
                    {
                        goodsList = goodsDao.findAllByState(1);
                    }
                    else {
                        goodsList = goodsDao.findByStateAndDetailClassifynameLikeAndDescriptionLike(1,"%"+detail_classifyname+"%","%"+key+"%");
                    }
                }
                else {
                    if (detail_classifyname.equals("请选择分类"))
                    {
                        goodsList = goodsDao.findByStateAndSummaryClassifynameLikeAndDescriptionLike(1,"%"+summary_classifyname+"%","%"+key+"%");
                    }
                    else {
                        goodsList = goodsDao.findByStateAndSummaryClassifynameLikeAndDetailClassifynameLikeAndDescriptionLike(1,"%"+summary_classifyname+"%","%"+detail_classifyname+"%","%"+key+"%");
                    }
                }
            }
        }
//        查询用户
        else {
            if(key.equals("物品"))
            {
                userList = userDao.findAll();
            }
            else
            {
            userList  = userDao.findByNicknameLike("%"+key+"%");
            }
        }
        model.addAttribute("goodsList",goodsList);
        model.addAttribute("userList",userList);
        return "login/homepage";
    }
}
