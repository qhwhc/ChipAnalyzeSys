package com.ccc.smse.service.impl;

import com.ccc.smse.dao.ChipYieldRepository;
import com.ccc.smse.pojo.ChipYield;
import com.ccc.smse.service.ChipYieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: cyb
 * @Date: 2019-03-18 20:12
 * @Version 1.0
 */
@Service
public class ChipYieldServiceImpl implements ChipYieldService {
    @Autowired
    ChipYieldRepository chipYieldRepository;
    @Override
    public void save(ChipYield chipYield) {
        chipYieldRepository.save(chipYield);
    }
}
