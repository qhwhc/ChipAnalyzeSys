package com.ccc.smse.common.util;

/**
 * @Author: cyb
 * @Date: 2019-04-06 10:31
 * @Version 1.0
 */
public class StringUtil {
    public static boolean isNull(String str){
        return  "".equals(str) || str == null || "null".equals(str);
    }
}
