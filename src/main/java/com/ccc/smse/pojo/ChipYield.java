package com.ccc.smse.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: cyb
 * @Date: 2019-03-18 19:50
 * @Version 1.0
 */
@Entity
@Table(name = "chip_yield")
public class ChipYield {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @Column(name = "batch_number")
    private String batchNumber;//批号
    @Column(name = "number_pieces")
    private int numberPieces;//片数
    @Column(name = "particles")
    private int particles;//颗粒数
    @Column(name = "yield")
    private double yield;//良率

    @OneToMany(mappedBy = "chipYield",fetch = FetchType.EAGER)
    private Set<ChipData> chipDataSet = new HashSet<ChipData>();

    public Set<ChipData> getChipDataSet() {
        return chipDataSet;
    }

    public void setChipDataSet(Set<ChipData> chipDataSet) {
        this.chipDataSet = chipDataSet;
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

    public int getNumberPieces() {
        return numberPieces;
    }

    public void setNumberPieces(int numberPieces) {
        this.numberPieces = numberPieces;
    }

    public int getParticles() {
        return particles;
    }

    public void setParticles(int particles) {
        this.particles = particles;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }
}