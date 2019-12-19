package com.ctgu.jiujiu_usedcar.dao;

import com.ctgu.jiujiu_usedcar.entity.AdminInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminInfoDao extends JpaRepository<AdminInfo, Integer> {
    //自定义的SQL查询
    List<AdminInfo> findByAdminNameAndAdminPassword(String adminName, String adminPassword);
}
