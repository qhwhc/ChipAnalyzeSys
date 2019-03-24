package com.ccc.smse.pojo;

import javax.persistence.Entity;
import java.util.List;

/**
 * @Author: cyb
 * @Date: 2019-03-24 16:29
 * @Version 1.0
 */

public class FilterCondition {
    private String dbName;
    private String showName;
    private List<String> showDatas;

    public String getDbName() {
        return dbName;
    }

    public FilterCondition setDbName(String dbName) {
        this.dbName = dbName;
        return this;
    }

    public String getShowName() {
        return showName;
    }

    public FilterCondition setShowName(String showNam) {
        this.showName = showNam;
        return this;
    }

    public List<String> getShowDatas() {
        return showDatas;
    }

    public FilterCondition setShowDatas(List<String> showDatas) {
        this.showDatas = showDatas;
        return this;
    }
}
