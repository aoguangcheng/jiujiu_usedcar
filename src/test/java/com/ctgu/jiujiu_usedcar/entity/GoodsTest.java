package com.ctgu.jiujiu_usedcar.entity;

import com.ctgu.jiujiu_usedcar.dao.GoodsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsTest {

    @Autowired
    GoodsDao goodsDao;

    @Test
    public void findOneGoods(){
        System.out.println(goodsDao.findById(1));
    }
}