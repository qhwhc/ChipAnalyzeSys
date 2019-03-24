package com.ccc.smse.pojo;

import javax.persistence.*;

/**
 * Created by Luowenlv on 2018/9/10,15:34
 */
@Entity
@Table(name = "banktb")
public class BankModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "docNumber")
    private String docNumber;
    @Column(name = "account")
    private String account;
    @Column(name = "firstTime")
    private String firstTime;
    @Column(name = "flag")
    private String flag;
    @Column(name = "unit")
    private String unit;
    @Column(name = "remark")
    private String remark;
    @Column(name = "info")
    private String info;
    @Column(name = "moneyOut")
    private String moneyOut;
    @Column(name = "moneyIn")
    private String moneyIn;
    @Column(name = "timeEnd")
    private String timeEnd;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMoneyOut() {
        return moneyOut;
    }

    public void setMoneyOut(String moneyOut) {
        this.moneyOut = moneyOut;
    }

    public String getMoneyIn() {
        return moneyIn;
    }

    public void setMoneyIn(String moneyIn) {
        this.moneyIn = moneyIn;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public String toString() {
        return "BankModel{" +
                "id=" + id +
                ", docNumber='" + docNumber + '\'' +
                ", account='" + account + '\'' +
                ", firstTime='" + firstTime + '\'' +
                ", flag='" + flag + '\'' +
                ", unit='" + unit + '\'' +
                ", remark='" + remark + '\'' +
                ", info='" + info + '\'' +
                ", moneyOut='" + moneyOut + '\'' +
                ", moneyIn='" + moneyIn + '\'' +
                ", timeEnd='" + timeEnd + '\'' +
                '}';
    }
}
