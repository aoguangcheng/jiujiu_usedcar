package com.ctgu.jiujiu_usedcar.dao;

import com.ctgu.jiujiu_usedcar.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsDao  extends JpaRepository<Goods,Integer>{
    List<Goods> findAllByState(Integer state);
    List<Goods> findAllByStateAndOwner(Integer state, String owener);
    Goods findGoodsByGoodNum(Integer goodNum);
    List<Goods> findByStateAndDetailClassifynameLikeAndDescriptionLike(Integer state,String detailClassifyname,String description);
    List<Goods> findByStateAndSummaryClassifynameLikeAndDescriptionLike(Integer state,String SummaryClassifyname,String description);
    List<Goods> findByStateAndSummaryClassifynameLikeAndDetailClassifynameLikeAndDescriptionLike(Integer state,String SummaryClassifyname,String detailClassifyname,String description);

    List<Goods> findByStateAndDetailClassifynameLike(Integer state,String detailClassifyname);
    List<Goods> findByStateAndSummaryClassifynameLike(Integer state,String SummaryClassifyname);
    List<Goods> findByStateAndSummaryClassifynameLikeAndDetailClassifynameLike(Integer state,String SummaryClassifyname,String detailClassifyname);

}
