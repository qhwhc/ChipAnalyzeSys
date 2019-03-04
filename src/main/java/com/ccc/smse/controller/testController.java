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
    public String toindex(){
        return "test";
    }
}
