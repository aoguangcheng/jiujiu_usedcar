package com.ctgu.jiujiu_usedcar.entity;

import com.ctgu.jiujiu_usedcar.dao.OrderDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderTest {

    @Autowired
    OrderDao orderDao;

    @Test
    public void findAllOrder(){
        System.out.println(orderDao.findByOrderid(1));
        List<Order> orderList = orderDao.findAll();
        for (Order order : orderList)
        {
            System.out.println(order);
        }
    }
}