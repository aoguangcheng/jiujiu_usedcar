package com.ctgu.jiujiu_usedcar.controller;

import com.ctgu.jiujiu_usedcar.dao.GoodsDao;
import com.ctgu.jiujiu_usedcar.dao.StarDao;
import com.ctgu.jiujiu_usedcar.entity.Goods;
import com.ctgu.jiujiu_usedcar.entity.Star;
import com.ctgu.jiujiu_usedcar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StarCon {
    @Autowired
    StarDao starDao;

    @Autowired
    GoodsDao goodsDao;

    @RequestMapping("tostarGoods")
    public  String starGoods(HttpSession session){
        //        在star表中插入数据
        Goods goods = (Goods)session.getAttribute("goodsobj");
        User user = (User)session.getAttribute("user");
        Star star = new Star(goods.getGoodNum(),user.getTelenum());
        starDao.save(star);
//        starDao.save(new Star(((Goods)session.getAttribute("goodsobj")).getGoodNum(),((User)session.getAttribute("user")).getTelenum()));
//        在goods表中修改startCount字段，使其+1

        Goods goods2 = goodsDao.findGoodsByGoodNum(goods.getGoodNum());
        goods2.setStarCount(goods2.getStarCount() + 1);
        goodsDao.save(goods2);
        return "redirect:/todetailGoods/"+ goods.getGoodNum().toString();
    }

    @RequestMapping("tocancleStarGoods")
    public String cancleStarGoods(HttpSession session){
        Goods goods = (Goods)session.getAttribute("goodsobj");
        User user = (User)session.getAttribute("user");
//        Star star = new Star(goods.getGoodNum(),user.getTelenum());
        List<Star> starList = starDao.findByGoodNumAndTelenum(goods.getGoodNum(),user.getTelenum());
//        删除stat表中的字段
        starDao.delete(starList.get(0));
//        在goods表中修改startcount字段的值，使其-1
        Goods goods2 = goodsDao.findGoodsByGoodNum(goods.getGoodNum());
        goods2.setStarCount(goods2.getStarCount() - 1);
        goodsDao.save(goods2);
        return "redirect:/todetailGoods/"+ goods.getGoodNum().toString();
    }

//    进入我的收藏
    @RequestMapping("touserStar")
    public String userStar(HttpSession session, Model model){
        User user = (User)session.getAttribute("user");
        List<Star> starList = starDao.findByTelenum(user.getTelenum());
        List<Goods> goodsList = new ArrayList<Goods>();
        for (Star star : starList)
        {
            goodsList.add(goodsDao.findGoodsByGoodNum(star.getGoodNum()));
        }
        model.addAttribute("goodsList",goodsList);
        return "user/userStar";
    }
}
