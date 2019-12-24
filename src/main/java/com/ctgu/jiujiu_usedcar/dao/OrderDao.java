package com.ctgu.jiujiu_usedcar.dao;

import com.ctgu.jiujiu_usedcar.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDao extends JpaRepository<Order,Integer> {
    Order findByOrderid(Integer id);
    List<Order> findByState( Integer state);
    List<Order> findByBuyerAndGoodnum(String telenum, Integer goodsnum);
    List<Order> findByBuyerAndState(String telenum, Integer state);
    List<Order> findBySellerAndState(String telenum, Integer state);
}
