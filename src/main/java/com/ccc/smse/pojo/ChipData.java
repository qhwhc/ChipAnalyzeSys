package com.ccc.smse.pojo;

import javax.persistence.*;

/**
 * @Author: cyb
 * @Date: 2019-03-18 19:45
 * @Version 1.0
 */
@Entity
@Table(name = "chip_data")
public class ChipData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "batch_number")
    private String batchNumber;//批号
    @Column(name = "product_code")
    private String productCode;//产品编码
    @Column(name = "version")
    private String version;//版本
    @Column(name = "number_pieces")
    private int numberPieces;//数量
    @Column(name = "process_period")
    private String processPeriod;//工序段
    @Column(name = "process")
    private String process;//工序
    @Column(name = "process_conditions")
    private String processConditions;//工艺条件
    @Column(name = "work_center")
    private String workCenter;//工作中心
    @Column(name = "work_unit")
    private String workUnit;//作业单元
    @Column(name = "operator")
    private String operator;//操作人
    @Column(name = "start_time")
    private String startTime;//当道开始时间
    @Column(name = "end_time")
    private String endTime;//当道结束时间

    @ManyToOne
    @JoinColumn(name = "chipDataSet",insertable = false,updatable = false)
    private ChipYield chipYield;//关联良率

    public ChipYield getChipYield() {
        return chipYield;
    }

    public void setChipYield(ChipYield chipYield) {
        this.chipYield = chipYield;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getNumberPieces() {
        return numberPieces;
    }

    public void setNumberPieces(int numberPieces) {
        this.numberPieces = numberPieces;
    }

    public String getProcessPeriod() {
        return processPeriod;
    }

    public void setProcessPeriod(String processPeriod) {
        this.processPeriod = processPeriod;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getProcessConditions() {
        return processConditions;
    }

    public void setProcessConditions(String processConditions) {
        this.processConditions = processConditions;
    }

    public String getWorkCenter() {
        return workCenter;
    }

    public void setWorkCenter(String workCenter) {
        this.workCenter = workCenter;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}