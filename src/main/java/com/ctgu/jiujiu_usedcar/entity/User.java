package com.ctgu.jiujiu_usedcar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "telenum")
    private String telenum;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "headicon")
    private String headicon;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "dwells")
    private String dwells;

    @Column(name = "college")
    private String college;

    @Column(name = "major")
    private String major;

    @Column(name = "grade")
    private String grade;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "dormitory")
    private String dormitory;

    @Column(name = "info_integrity")
    private Integer infoIntegrity;

    public User(String telenum, String password, String nickname, String headicon, String sex, String birthday, String dwells, String college, String major, String grade, String hobby, String dormitory, Integer infoIntegrity) {
        this.telenum = telenum;
        this.password = password;
        this.nickname = nickname;
        this.headicon = headicon;
        this.sex = sex;
        this.birthday = birthday;
        this.dwells = dwells;
        this.college = college;
        this.major = major;
        this.grade = grade;
        this.hobby = hobby;
        this.dormitory = dormitory;
        this.infoIntegrity = infoIntegrity;
    }

    public User() {
    }

    public String getTelenum() {
        return telenum;
    }

    public void setTelenum(String telenum) {
        this.telenum = telenum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadicon() {
        return headicon;
    }

    public void setHeadicon(String headicon) {
        this.headicon = headicon;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String
                                    birthday) {
        this.birthday = birthday;
    }

    public String getDwells() {
        return dwells;
    }

    public void setDwells(String dwells) {
        this.dwells = dwells;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public Integer getInfoIntegrity() {
        return infoIntegrity;
    }

    public void setInfoIntegrity(Integer infoIntegrity) {
        this.infoIntegrity = infoIntegrity;
    }

    @Override
    public String toString() {
        return "User{" +
                "telenum='" + telenum + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", headicon='" + headicon + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", dwells='" + dwells + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", hobby='" + hobby + '\'' +
                ", dormitory='" + dormitory + '\'' +
                ", infoIntegrity=" + infoIntegrity +
                '}';
    }
}
