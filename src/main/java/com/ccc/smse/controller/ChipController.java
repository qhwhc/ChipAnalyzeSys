package com.ccc.smse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: cyb
 * @Date: 2019-03-11 20:40
 * @Version 1.0
 */
@Controller
public class ChipController {
    @RequestMapping("chipTab")
    public String toChipIndex(){
        return  "chipTab";
    }
}
