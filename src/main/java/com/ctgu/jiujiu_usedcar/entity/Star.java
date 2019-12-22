package com.ctgu.jiujiu_usedcar.entity;

import javax.persistence.*;

@Entity
@Table(name = "star")
public class Star {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "starid")
    private Integer starid;

    @Column(name = "good_num")
    private Integer goodNum;

    @Column(name = "telenum")
    private String telenum;

    public Star(Integer goodNum, String telenum) {
        this.goodNum = goodNum;
        this.telenum = telenum;
    }

    public Star() {
    }

    public Integer getStarid() {
        return starid;
    }

    public void setStarid(Integer starid) {
        this.starid = starid;
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
        return "Star{" +
                "starid=" + starid +
                ", goodNum=" + goodNum +
                ", telenum='" + telenum + '\'' +
                '}';
    }
}
