package com.ccc.smse.controller;

import com.ccc.smse.pojo.ChipData;
import com.ccc.smse.service.ChipDataService;
import com.ccc.smse.service.FilterConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    @RequestMapping("chipYield")
    public String toChipYield(@RequestParam(required = false) String filterData,Model model){
        List<ChipData> chipDatas = chipDataService.findAll();
        model.addAttribute("chipDatas",chipDatas);
        model.addAttribute("filterDatas",filterConditionService.getConditions());
        return "chipYield";
    }

}
