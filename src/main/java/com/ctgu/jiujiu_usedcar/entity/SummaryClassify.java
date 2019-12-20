package com.ctgu.jiujiu_usedcar.entity;

import javax.persistence.*;

@Entity
@Table(name = "summary_classify")
public class SummaryClassify {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "summary_num")
    private Integer summaryNum;

    @Column(name = "summary_classifyname")
    private String summaryClassifyname;

    public SummaryClassify() {
    }

    public SummaryClassify(String summaryClassifyname) {
        this.summaryClassifyname = summaryClassifyname;
    }

    public Integer getSummaryNum() {
        return summaryNum;
    }

    public void setSummaryNum(Integer summaryNum) {
        this.summaryNum = summaryNum;
    }

    public String getSummaryClassifyname() {
        return summaryClassifyname;
    }

    public void setSummaryClassifyname(String summaryClassifyname) {
        this.summaryClassifyname = summaryClassifyname;
    }

    @Override
    public String toString() {
        return "summaryClassify{" +
                "summaryNum=" + summaryNum +
                ", summaryClassifyname='" + summaryClassifyname + '\'' +
                '}';
    }
}
