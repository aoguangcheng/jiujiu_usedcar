package com.ctgu.jiujiu_usedcar.dao;

import com.ctgu.jiujiu_usedcar.entity.adminInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface adminInfoDao extends JpaRepository<adminInfo, Integer>{
    //自定义的SQL查询
    List<adminInfo> findByAdminNameAndAdminPassword(String adminName, String adminPassword);
}
