package com.ctgu.jiujiu_usedcar.controller;

import com.ctgu.jiujiu_usedcar.config.UploadConfig;
import com.ctgu.jiujiu_usedcar.dao.*;
import com.ctgu.jiujiu_usedcar.entity.*;
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

    @Autowired
    LeaveMessageDao leaveMessageDao;

    @Autowired
    StarDao starDao;

    @Autowired
    BrowseRecordDao browseRecordDao;

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
    //进入到详情页
    @RequestMapping("/todetailGoods/{id}")
    public String detailGoods(@PathVariable("id") Integer goodsNum,
                              Model model,
                              HttpSession session){
        Goods goods = goodsDao.findGoodsByGoodNum(goodsNum);
        model.addAttribute("goods",goods);
        session.setAttribute("goodsobj",goods);
        List<LeaveMessage> leaveMessageList = leaveMessageDao.findByGoodNum(goodsNum);
        model.addAttribute("leaveMessageList",leaveMessageList);
        /*
        * 处理收藏的问题*/
        if(session.getAttribute("user") == null)
        {

        }
        else {
//            处理详情页的收藏问题
            User user = ((User)session.getAttribute("user"));
            List<Star> starList = starDao.findByGoodNumAndTelenum(goods.getGoodNum(),user.getTelenum());
            session.setAttribute("star",starList);
//            处理进入详情页添加浏览记录，先判断浏览记录表中有没有记录，如果没有则插入数据，否则不坐处理
            List<BrowseRecord> browseRecordList = browseRecordDao.findByGoodNumAndTelenum(goodsNum,user.getTelenum());
            if (browseRecordList.size() == 0)
            {
//                插入浏览记录
                BrowseRecord browseRecord = new BrowseRecord(goodsNum,user.getTelenum());
                browseRecordDao.save(browseRecord);
            }
            else {
//                不操作
            }
        }

        return "detailGoods";
    }

//    进入到已出售界面
    @RequestMapping("touserSold")
    public String userSold(Model model,
                              HttpSession session){
        User user = (User)session.getAttribute("user");
        List<Goods> goodsList = goodsDao.findAllByStateAndOwner(3,user.getTelenum());
        model.addAttribute("goodsList",goodsList);
        return "userSold";

    }
//    下架物品
    @RequestMapping("toPutdownGoods")
    public String PutdownGoods(HttpSession session){
        Goods goods = (Goods)session.getAttribute("goodsobj");
        System.out.println(goods);
        goods.setState(2);
        System.out.println(goods);
        System.out.println("已下架");
        goodsDao.save(goods);

        return "redirect:/todetailGoods/"+ goods.getGoodNum().toString();
    }

//    上架物品
    @RequestMapping("toPutUpGoods")
    public String PutUpGoods(HttpSession session){
        Goods goods = (Goods)session.getAttribute("goodsobj");
        System.out.println(goods);
        goods.setState(1);
        System.out.println(goods);
        goodsDao.save(goods);
        System.out.println("已上架");
        return "redirect:/todetailGoods/"+ goods.getGoodNum().toString();
    }

//    修改物品
    @RequestMapping("toeditGoodsPage")
    public String editGoods(){
        return "editGoods";
    }

    @RequestMapping("toeditGoods")
    public String editGoods(@RequestParam("pic1") MultipartFile file1,
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

        Goods goods = (Goods)session.getAttribute("goodsobj");
        System.out.println(goods);
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
        System.out.println(goods);
        goodsDao.save(goods);
        session.setAttribute("goodsobj",goods);
        return "redirect:/todetailGoods/"+ goods.getGoodNum().toString();
    }
}