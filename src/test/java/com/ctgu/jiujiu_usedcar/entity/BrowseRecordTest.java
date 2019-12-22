package com.ctgu.jiujiu_usedcar.entity;

import com.ctgu.jiujiu_usedcar.dao.BrowseRecordDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrowseRecordTest {
    @Autowired
    BrowseRecordDao browseRecordDao;

    @Test
    public  void findAllBrowseRecord(){
        List<BrowseRecord> browseRecordList = browseRecordDao.findAll();
        for (BrowseRecord browseRecord : browseRecordList)
        {
            System.out.println(browseRecord);
        }
    }
}