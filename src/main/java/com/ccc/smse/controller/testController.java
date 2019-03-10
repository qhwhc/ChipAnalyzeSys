package com.ccc.smse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: cyb
 * @Date: 2019-03-04 21:40
 * @Version 1.0
 */
@Controller
public class testController {
    @RequestMapping("hello")
    public String totest(){
        return "test";
    }
    @RequestMapping("index")
    public String toindex(){
        return "index";
    }

    @RequestMapping("menu")
    public String toMenu(){
        return "commonTemp/menu";
    }

    @RequestMapping("testMenu")
    public  String toMenuTest(){
        return "testMenu";
    }
    @RequestMapping("echartsDemo")
    public  String toEchartsDemo(){
        return "echartsTemp/lineChart";
    }
}
