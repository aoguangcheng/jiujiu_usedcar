package com.ctgu.jiujiu_usedcar.entity;

import javax.persistence.*;

@Entity
@Table(name = "detail_classify")
public class DetailClassify {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "detail_num")
    private Integer detailNum;

    @Column(name = "detail_classifyname")
    private String detailClassifyname;

    @Column(name = "summary_classifyname")
    private String summaryClassifyname;

    public DetailClassify(String detailClassifyname, String summaryClassifyname) {
        this.detailClassifyname = detailClassifyname;
        this.summaryClassifyname = summaryClassifyname;
    }

    public DetailClassify() {
    }

    public Integer getDetailNum() {
        return detailNum;
    }

    public void setDetailNum(Integer detailNum) {
        this.detailNum = detailNum;
    }

    public String getDetailClassifyname() {
        return detailClassifyname;
    }

    public void setDetailClassifyname(String detailClassifyname) {
        this.detailClassifyname = detailClassifyname;
    }

    public String getSummaryClassifyname() {
        return summaryClassifyname;
    }

    public void setSummaryClassifyname(String summaryClassifyname) {
        this.summaryClassifyname = summaryClassifyname;
    }

    @Override
    public String toString() {
        return "DetailClassify{" +
                "detailNum=" + detailNum +
                ", detailClassifyname='" + detailClassifyname + '\'' +
                ", summaryClassifyname='" + summaryClassifyname + '\'' +
                '}';
    }
}
