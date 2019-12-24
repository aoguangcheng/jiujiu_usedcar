package com.ctgu.jiujiu_usedcar.controller;

import com.ctgu.jiujiu_usedcar.dao.BrowseRecordDao;
import com.ctgu.jiujiu_usedcar.dao.GoodsDao;
import com.ctgu.jiujiu_usedcar.entity.BrowseRecord;
import com.ctgu.jiujiu_usedcar.entity.Goods;
import com.ctgu.jiujiu_usedcar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BrowseRecordCon {

    @Autowired
    GoodsDao goodsDao;
    @Autowired
    BrowseRecordDao browseRecordDao;

    @RequestMapping("touserBrowseRecord")
    public  String userBrowseRecord(HttpSession session,
                                    Model model){
        User user = (User)session.getAttribute("user");
        List<BrowseRecord> browseRecordList = browseRecordDao.findByTelenum(user.getTelenum());
        List<Goods> goodsList = new ArrayList<Goods>();
        for (BrowseRecord browseRecord : browseRecordList)
        {
            goodsList.add(goodsDao.findGoodsByGoodNum(browseRecord.getGoodNum()));
        }
        model.addAttribute("goodsList",goodsList);
        return "user/userBrowseRecord";
    }
}
