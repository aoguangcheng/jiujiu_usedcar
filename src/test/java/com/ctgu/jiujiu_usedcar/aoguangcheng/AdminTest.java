package com.ctgu.jiujiu_usedcar.aoguangcheng;

import com.ctgu.jiujiu_usedcar.dao.AdminInfoDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminTest {
    @Autowired
    AdminInfoDao infoDao;

    @Test
    public void getAdminInfo(){
        System.out.println(infoDao.findByAdminNameAndAdminPassword("admin","admin").toString());
    }
}
