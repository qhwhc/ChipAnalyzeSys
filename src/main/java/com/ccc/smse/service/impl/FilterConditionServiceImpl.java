package com.ccc.smse.service.impl;

import com.ccc.smse.dao.ChipDataRepository;
import com.ccc.smse.service.FilterConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public Map<String, List<String>> getConditions() {
        Map<String, List<String>> conditions = new LinkedHashMap<String,List<String>>();
        conditions.put("产品编码",chipDataRepository.findProductCode());
        conditions.put("工序段",chipDataRepository.findProcessPeriod());
        conditions.put("工序",chipDataRepository.findProcess());
        conditions.put("工艺条件",chipDataRepository.findProcessConditions());
        conditions.put("工作中心",chipDataRepository.findWorkCenter());
        conditions.put("工作单元",chipDataRepository.findWorkUnit());
        conditions.put("操作人",chipDataRepository.findOperator());
        return conditions;
    }
}
