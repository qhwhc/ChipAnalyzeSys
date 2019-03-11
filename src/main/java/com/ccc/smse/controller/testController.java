package com.ccc.smse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

}
