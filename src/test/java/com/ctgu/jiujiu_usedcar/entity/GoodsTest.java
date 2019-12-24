package com.ctgu.jiujiu_usedcar.entity;

import com.ctgu.jiujiu_usedcar.dao.GoodsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsTest {

    @Autowired
    GoodsDao goodsDao;

    @Test
    public void findOneGoods(){
        System.out.println(goodsDao.findById(1));
    }

    @Test
    public void  goodsQuery(){
        List<Goods> goodsList = goodsDao.findByStateAndDetailClassifynameLikeAndDescriptionLike(1,"%机%","%手机%");
        for (Goods goods : goodsList)
        {
            System.out.println("1");
            System.out.println(goods);
        }

        List<Goods> goodsList1 = goodsDao.findByStateAndSummaryClassifynameLikeAndDescriptionLike(1,"%机%","%手机%");
        for (Goods goods : goodsList1)
        {
            System.out.println("2");
            System.out.println(goods);
        }

        List<Goods> goodsList2 = goodsDao.findByStateAndSummaryClassifynameLikeAndDetailClassifynameLikeAndDescriptionLike(1,"%数码%","%手机%","%手机%");
        for (Goods goods : goodsList2)
        {
            System.out.println("3");
            System.out.println(goods);
        }
    }
}