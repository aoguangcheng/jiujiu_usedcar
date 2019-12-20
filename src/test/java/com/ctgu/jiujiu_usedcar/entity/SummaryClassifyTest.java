package com.ctgu.jiujiu_usedcar.entity;

import com.ctgu.jiujiu_usedcar.dao.SummaryClassifyDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SummaryClassifyTest {

    @Autowired
    SummaryClassifyDao summaryClassifyDao;

    @Test
    public void findOneSummaryClassify(){
        System.out.println(summaryClassifyDao.findById(1));
    }
}