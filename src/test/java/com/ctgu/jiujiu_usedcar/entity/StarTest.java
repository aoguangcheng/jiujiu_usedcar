package com.ctgu.jiujiu_usedcar.entity;

import com.ctgu.jiujiu_usedcar.dao.GoodsDao;
import com.ctgu.jiujiu_usedcar.dao.StarDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StarTest {
    @Autowired
    StarDao starDao;
    @Autowired
    GoodsDao goodsDao;

    @Test
    public void findAllStar(){
        List<Star> starList = starDao.findAll();
        for(Star star : starList)
        {
            System.out.println(star);
        }
    }

    @Test
//    根据手机号输出该用户收藏的物品
    public void findUserStar(){
        List<Star> starList = starDao.findByTelenum("admin");
        List<Goods> goodsList = new ArrayList<Goods>();
        for (Star star : starList)
        {
            goodsList.add(goodsDao.findGoodsByGoodNum(star.getGoodNum()));
        }
        for (Goods goods : goodsList)
        {
            System.out.println(goods.toString());
        }
    }

}