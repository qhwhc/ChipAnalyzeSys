package com.ccc.smse.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: cyb
 * @Date: 2019-03-24 16:44
 * @Version 1.0
 */
@Entity
public class FilterData {
    @Id
    private String productCode;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
