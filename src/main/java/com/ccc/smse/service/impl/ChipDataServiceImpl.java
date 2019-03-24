package com.ccc.smse.service.impl;

import com.ccc.smse.dao.ChipDataRepository;
import com.ccc.smse.pojo.ChipData;
import com.ccc.smse.service.ChipDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: cyb
 * @Date: 2019-03-18 20:11
 * @Version 1.0
 */
@Service
public class ChipDataServiceImpl implements ChipDataService {
    @Autowired
    ChipDataRepository chipDataRepository;
    @Override
    public List<ChipData> findAll() {
        return chipDataRepository.findAll();
    }
}
