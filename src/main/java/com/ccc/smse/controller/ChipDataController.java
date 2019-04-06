package com.ccc.smse.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ccc.smse.common.util.StringUtil;
import com.ccc.smse.pojo.ChipData;
import com.ccc.smse.pojo.WebMenu;
import com.ccc.smse.service.ChipDataService;
import com.ccc.smse.service.FilterConditionService;
import com.ccc.smse.service.WebMenuService;
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
    @Autowired
    WebMenuService webMenuService;
    @GetMapping(value="index")
    public String toChipYield(@RequestParam(required = false) String filterData,@RequestParam(required = false)String jumpto, String start,String end,String q,Model model){
        /*菜单查询*/
        List<WebMenu> webMenuList = webMenuService.findAll();
        StringBuilder webMenu = new StringBuilder();
        for(WebMenu WebMenu:webMenuList){
            webMenu.append(WebMenu);
        }
        model.addAttribute("webMenu",webMenu.toString());
        if("data".equals(jumpto)){
            return "data";
        }
        List<ChipData> chipDatas;
        if(StringUtil.isNull(filterData) && StringUtil.isNull(start) && StringUtil.isNull(end) && StringUtil.isNull(q)) {
            chipDatas = chipDataService.findAll();
        } else {
            JSONObject jsonObject = JSON.parseObject(filterData);
            if(jsonObject == null) jsonObject = new JSONObject();
            if(!StringUtil.isNull(q)) jsonObject.put("q",q);
            if(!StringUtil.isNull(start)) jsonObject.put("start",start);
            if(!StringUtil.isNull(end))jsonObject.put("end",end);
            chipDatas =chipDataService.findAllByConditions(jsonObject);
        }
        model.addAttribute("chipDatas",chipDatas);
        model.addAttribute("filterDatas",filterConditionService.getConditions());
        String[] xAxis = new String[chipDatas.size()];
        float[] yAxis = new float[chipDatas.size()];

        for (int i = 0; i < chipDatas.size(); i++) {
            xAxis[i] = chipDatas.get(i).getBatchNumber();
            if(chipDatas.get(i).getChipYield() == null){
                yAxis[i] = 0;
                continue;}
            String percent = chipDatas.get(i).getChipYield().getYield().replace("%","");
            yAxis[i] = Float.valueOf(percent) / 100;;
        }
        model.addAttribute("xAxis",xAxis);
        model.addAttribute("yAxis",yAxis);
        return "chipYield";
    }
}
