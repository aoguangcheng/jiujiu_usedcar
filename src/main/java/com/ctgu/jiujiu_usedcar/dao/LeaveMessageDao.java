package com.ctgu.jiujiu_usedcar.dao;

import com.ctgu.jiujiu_usedcar.entity.LeaveMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveMessageDao extends JpaRepository<LeaveMessage,Integer>{
    List<LeaveMessage> findByGoodNum(Integer goodNum);
}
