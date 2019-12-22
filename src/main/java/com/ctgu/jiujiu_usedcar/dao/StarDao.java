package com.ctgu.jiujiu_usedcar.dao;

import com.ctgu.jiujiu_usedcar.entity.Star;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StarDao extends JpaRepository<Star,Integer> {
    List<Star> findByGoodNumAndTelenum(Integer goodsnum, String telenum);
    List<Star> findByTelenum(String telenum);
}
