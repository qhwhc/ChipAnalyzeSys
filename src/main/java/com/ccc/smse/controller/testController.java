package com.ccc.smse.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ccc.smse.pojo.ChipData;
import com.ccc.smse.pojo.FilterCondition;
import com.ccc.smse.pojo.FilterData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: cyb
 * @Date: 2019-03-04 21:40
 * @Version 1.0
 */
@Controller
public class testController {
    /*菜单跳转*/
    @RequestMapping("test")
    public String jumpTo(@RequestParam(required = false) String jumpto){
        return jumpto;
    }

    @RequestMapping("ajaxTest")
    @ResponseBody
    public String ajaxTest(@RequestBody Map<String,Object> map){
        JSONObject jsonObject = JSON.parseObject(map.get("filterData").toString());
        System.out.println(jsonObject.getString("productCode"));
        System.out.println(jsonObject.getString("processPeriod"));
        return "true";
    }
}
