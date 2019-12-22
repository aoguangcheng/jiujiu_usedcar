package com.ctgu.jiujiu_usedcar.entity;

import javax.persistence.*;

@Entity
@Table(name = "browse_record")
public class BrowseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recordid")
    private Integer recordid;

    @Column(name = "good_num")
    private Integer goodNum;

    @Column(name = "telenum")
    private String telenum;

    public BrowseRecord() {
    }

    public BrowseRecord(Integer goodNum, String telenum) {
        this.goodNum = goodNum;
        this.telenum = telenum;
    }

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public String getTelenum() {
        return telenum;
    }

    public void setTelenum(String telenum) {
        this.telenum = telenum;
    }

    @Override
    public String toString() {
        return "BrowseRecord{" +
                "recordid=" + recordid +
                ", goodNum=" + goodNum +
                ", telenum='" + telenum + '\'' +
                '}';
    }
}
