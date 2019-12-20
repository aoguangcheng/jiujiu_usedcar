package com.ctgu.jiujiu_usedcar.entity;

import javax.persistence.*;

@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "good_num")
    private Integer goodNum;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private String price;
    @Column(name = "summary_classifyname")
    private String summaryClassifyname;
    @Column(name = "detail_classifyname")
    private String detailClassifyname;
    @Column(name = "pic1")
    private String pic1;
    @Column(name = "pic2")
    private String pic2;
    @Column(name = "pic3")
    private String pic3;
    @Column(name = "state")
    private Integer state;
    @Column(name = "owner")
    private String owner;
    @Column(name = "star_count")
    private Integer starCount;
    @Column(name = "pur_comment")
    private String purComment;

    @Override
    public String toString() {
        return "Goods{" +
                "goodNum=" + goodNum +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", summaryClassifyname='" + summaryClassifyname + '\'' +
                ", detailClassifyname='" + detailClassifyname + '\'' +
                ", pic1='" + pic1 + '\'' +
                ", pic2='" + pic2 + '\'' +
                ", pic3='" + pic3 + '\'' +
                ", state=" + state +
                ", owner='" + owner + '\'' +
                ", starCount=" + starCount +
                ", purComment='" + purComment + '\'' +
                '}';
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSummaryClassifyname() {
        return summaryClassifyname;
    }

    public void setSummaryClassifyname(String summaryClassifyname) {
        this.summaryClassifyname = summaryClassifyname;
    }

    public String getDetailClassifyname() {
        return detailClassifyname;
    }

    public void setDetailClassifyname(String detailClassifyname) {
        this.detailClassifyname = detailClassifyname;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getStarCount() {
        return starCount;
    }

    public void setStarCount(Integer starCount) {
        this.starCount = starCount;
    }

    public String getPurComment() {
        return purComment;
    }

    public void setPurComment(String purComment) {
        this.purComment = purComment;
    }

    public Goods() {
    }

    public Goods(String description, String price, String summaryClassifyname, String detailClassifyname, String pic1, String pic2, String pic3, Integer state, String owner, Integer starCount, String purComment) {
        this.description = description;
        this.price = price;
        this.summaryClassifyname = summaryClassifyname;
        this.detailClassifyname = detailClassifyname;
        this.pic1 = pic1;
        this.pic2 = pic2;
        this.pic3 = pic3;
        this.state = state;
        this.owner = owner;
        this.starCount = starCount;
        this.purComment = purComment;
    }
}
