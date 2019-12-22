package com.ctgu.jiujiu_usedcar.controller;

import com.ctgu.jiujiu_usedcar.dao.LeaveMessageDao;
import com.ctgu.jiujiu_usedcar.entity.Goods;
import com.ctgu.jiujiu_usedcar.entity.LeaveMessage;
import com.ctgu.jiujiu_usedcar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
@Controller
public class LeaveMessageCon {
    @Autowired
    LeaveMessageDao leaveMessageDao;

//    处理提交的留言

    @RequestMapping("tosubmitMessage")
//    @RequestBody("tosubmitMessage")
    public String submitMessage(@RequestParam("message") String message,
                              HttpSession session){
        Goods goods = (Goods)session.getAttribute("goodsobj");
        LeaveMessage leaveMessage = new LeaveMessage();
        //物品编号作为session取出来
//        Integer.parseInt(session.getAttribute("goodsnum"));
        leaveMessage.setGoodNum(goods.getGoodNum());
//        取出发布者编号
        User user = (User)session.getAttribute("user");
//        String.valueOf(user.getTelenum());
        leaveMessage.setTelenum(String.valueOf(user.getTelenum()));
//        获取当前时间格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        simpleDateFormat.format(new Date());
        leaveMessage.setDate(simpleDateFormat.format(new Date()));
        leaveMessage.setMessage(message);
        leaveMessageDao.save(leaveMessage);
        System.out.println("发布留言");
        return "redirect:/todetailGoods/"+ goods.getGoodNum().toString();
//        return "redirect:/";
    }

}
