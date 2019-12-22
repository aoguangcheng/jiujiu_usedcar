package com.ctgu.jiujiu_usedcar.entity;

import com.ctgu.jiujiu_usedcar.dao.LeaveMessageDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LeaveMessageTest {
    @Autowired
    LeaveMessageDao leaveMessageDao;

    @Test
    public void finAllLeaveMessage(){
        List<LeaveMessage> leaveMessageList = leaveMessageDao.findAll();
        for (LeaveMessage leaveMessage : leaveMessageList)
        {
            System.out.println(leaveMessage);

        }
    }
}