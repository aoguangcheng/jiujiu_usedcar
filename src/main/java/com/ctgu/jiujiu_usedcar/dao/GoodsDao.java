package com.ctgu.jiujiu_usedcar.dao;

import com.ctgu.jiujiu_usedcar.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsDao  extends JpaRepository<Goods,Integer>{
    List<Goods> findAllByState(Integer state);
    List<Goods> findAllByStateAndOwner(Integer state, String owener);
    Goods findGoodsByGoodNum(Integer goodNum);
}
