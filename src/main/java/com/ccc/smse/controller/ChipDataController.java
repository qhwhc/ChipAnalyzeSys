package com.ccc.smse.controller;

import com.ccc.smse.pojo.ChipData;
import com.ccc.smse.service.ChipDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("chipYield")
    public String toChipYield(Model model){
        List<ChipData> chipDatas = chipDataService.findAll();
        model.addAttribute("chipDatas",chipDatas);
        return "chipYield";
    }
}
