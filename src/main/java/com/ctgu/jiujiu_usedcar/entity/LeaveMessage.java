package com.ctgu.jiujiu_usedcar.entity;

import javax.persistence.*;

@Entity
@Table(name = "leave_message")
public class LeaveMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messageid")
    private Integer messageid;

    @Column(name = "good_num")
    private Integer goodNum;

    @Column(name = "telenum")
    private String telenum;

    @Column(name = "date")
    private String date;

    @Column(name = "message")
    private String message;

    public LeaveMessage() {
    }

    public LeaveMessage(Integer goodNum, String telenum, String date, String message) {
        this.goodNum = goodNum;
        this.telenum = telenum;
        this.date = date;
        this.message = message;
    }

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LeaveMessageDao{" +
                "messageid=" + messageid +
                ", goodNum=" + goodNum +
                ", telenum='" + telenum + '\'' +
                ", date='" + date + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
