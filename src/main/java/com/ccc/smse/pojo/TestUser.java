package com.ccc.smse.pojo;

import javax.persistence.*;

/**
 * @Author: cyb
 * @Date: 2019-03-17 11:19
 * @Version 1.0
 */
@Entity
@Table(name="test_user")
public class TestUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
