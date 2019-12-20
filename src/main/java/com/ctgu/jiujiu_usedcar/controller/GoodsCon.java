package com.ctgu.jiujiu_usedcar.controller;

import com.ctgu.jiujiu_usedcar.config.UploadConfig;
import com.ctgu.jiujiu_usedcar.dao.GoodsDao;
import com.ctgu.jiujiu_usedcar.dao.UserDao;
import com.ctgu.jiujiu_usedcar.entity.Goods;
import com.ctgu.jiujiu_usedcar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GoodsCon {
    @Autowired
    UserDao userDao;

    @Autowired
    GoodsDao goodsDao;

    @RequestMapping("toaddGoods")
    public String toaddGoods(){
        return "addgoods";
    }

    @RequestMapping("addgoods")
    public String addgoods(@RequestParam("pic1") MultipartFile file1,
                           @RequestParam("pic2") MultipartFile file2,
                           @RequestParam("pic3") MultipartFile file3,
                           @RequestParam("summary_classifyname") String summaryClassifyname,
                           @RequestParam("detail_classifyname") String detailClassifyname,
                           @RequestParam("price") String price,
                           @RequestParam("description") String description,
                           HttpSession session){
        System.out.println(summaryClassifyname);
        System.out.println(detailClassifyname);
        System.out.println(price);
        System.out.println(description);
        Goods goods = new Goods();
        UploadConfig uploadConfig = new UploadConfig();
        uploadConfig.uploadFile(file1);
        goods.setPic1(uploadConfig.getCompleteFilepath());

        uploadConfig.uploadFile(file2);
        goods.setPic2(uploadConfig.getCompleteFilepath());

        uploadConfig.uploadFile(file3);
        goods.setPic3(uploadConfig.getCompleteFilepath());

        goods.setSummaryClassifyname(summaryClassifyname);
        goods.setDetailClassifyname(detailClassifyname);
        goods.setDescription(description);
        goods.setPrice(price);
        goods.setState(1);
        goods.setStarCount(0);
        User user = (User)session.getAttribute("user");
        goods.setOwner(user.getTelenum());
        goods.setPurComment("无");

        goodsDao.save(goods);
        return "redirect:/";
    }

    @RequestMapping("touserRelease")
    public String userRelease(Model model,HttpSession session){
        User user = (User)session.getAttribute("user");
        List<Goods> goodsList = goodsDao.findAllByStateAndOwner(1,user.getTelenum());
        model.addAttribute("goodsList",goodsList);
        return "userRelease";
    }

    @RequestMapping("touserPutdown")
    public String userPutdown(Model model,
                              HttpSession session){
        User user = (User)session.getAttribute("user");
        List<Goods> goodsList = goodsDao.findAllByStateAndOwner(2,user.getTelenum());
        model.addAttribute("goodsList",goodsList);
        return "userPutdown";
    }

    @RequestMapping("/todetailGoods/{id}")
    public String detailGoods(@PathVariable("id") Integer goodsNum){
        Goods goods = goodsDao.findById()
        return "detailGoods";
    }
}
