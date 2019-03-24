package com.ccc.smse.service.impl;

import com.ccc.smse.dao.ChipDataRepository;
import com.ccc.smse.pojo.FilterCondition;
import com.ccc.smse.service.FilterConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: cyb
 * @Date: 2019-03-24 11:45
 * @Version 1.0
 */
@Service
public class FilterConditionServiceImpl implements FilterConditionService {
    @Autowired
    private ChipDataRepository chipDataRepository;
    @Override
    public List<FilterCondition> getConditions() {
        List<FilterCondition> conditions = new ArrayList<FilterCondition>();
        conditions.add(new FilterCondition().setDbName("productCode").setShowName("产品编码").setShowDatas(chipDataRepository.findProductCode()));
        conditions.add(new FilterCondition().setDbName("processPeriod").setShowName("工序段").setShowDatas(chipDataRepository.findProcessPeriod()));
        conditions.add(new FilterCondition().setDbName("process").setShowName("工序").setShowDatas(chipDataRepository.findProcess()));
        conditions.add(new FilterCondition().setDbName("processConditions").setShowName("工艺条件").setShowDatas(chipDataRepository.findProcessConditions()));
        conditions.add(new FilterCondition().setDbName("workCenter").setShowName("工作中心").setShowDatas(chipDataRepository.findWorkCenter()));
        conditions.add(new FilterCondition().setDbName("workUnit(").setShowName("工作单元").setShowDatas(chipDataRepository.findWorkUnit()));
        conditions.add(new FilterCondition().setDbName("operator").setShowName("操作人").setShowDatas(chipDataRepository.findOperator()));
        return conditions;
    }
}
