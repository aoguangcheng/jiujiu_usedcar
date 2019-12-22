package com.ctgu.jiujiu_usedcar.entity;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private Integer orderid;

    @Column(name = "goodnum")
    private Integer goodnum;

    @Column(name = "buyer")
    private String buyer;

    @Column(name = "seller")
    private String seller;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private String date;

    @Column(name = "price")
    private String price;

    @Column(name = "state")
    private  Integer state;

    public Order() {
    }

    public Order(Integer goodNum, String buyer, String seller, String description, String date, String price, Integer state) {
        this.goodnum = goodNum;
        this.buyer = buyer;
        this.seller = seller;
        this.description = description;
        this.date = date;
        this.price = price;
        this.state = state;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getGoodNum() {
        return goodnum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodnum = goodNum;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", goodNum=" + goodnum +
                ", buyer='" + buyer + '\'' +
                ", seller='" + seller + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", price='" + price + '\'' +
                ", state=" + state +
                '}';
    }
}
