package com.ccc.smse.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ccc.smse.pojo.ChipData;
import com.ccc.smse.service.ChipDataService;
import com.ccc.smse.service.FilterConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: cyb
 * @Date: 2019-03-23 13:54
 * @Version 1.0
 */
@Controller
public class ChipDataController {
    @Autowired
    ChipDataService chipDataService;
    @Autowired
    FilterConditionService filterConditionService;

    @GetMapping(value="chipYield")
    public String toChipYield(@RequestParam(required = false) String filterData,Model model){
        System.out.println(filterData);
        List<ChipData> chipDatas;
        if("".equals(filterData) || filterData == null) {
            chipDatas = chipDataService.findAll();
        } else {
            JSONObject jsonObject = JSON.parseObject(filterData);
            chipDatas =chipDataService.findAllByConditions(jsonObject);
        }
        model.addAttribute("chipDatas",chipDatas);
        model.addAttribute("filterDatas",filterConditionService.getConditions());
        String[] xAxis = new String[chipDatas.size()];
        float[] yAxis = new float[chipDatas.size()];

        for (int i = 0; i < chipDatas.size(); i++) {
            xAxis[i] = chipDatas.get(i).getBatchNumber();
            String percent = chipDatas.get(i).getChipYield().getYield().replace("%","");
            yAxis[i] = Float.valueOf(percent) / 100;;
        }
        model.addAttribute("xAxis",xAxis);
        model.addAttribute("yAxis",yAxis);
        return "chipYield";
    }
}
