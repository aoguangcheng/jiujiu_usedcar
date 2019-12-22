package com.ctgu.jiujiu_usedcar.dao;

import com.ctgu.jiujiu_usedcar.entity.BrowseRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrowseRecordDao extends JpaRepository<BrowseRecord,Integer> {
    List<BrowseRecord> findByGoodNumAndTelenum(Integer goodsnum, String telenum);
    List<BrowseRecord> findByTelenum(String telenum);
}
