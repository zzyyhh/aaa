package com.zyh.code.string;

/**
 * @author yinghui.zhang on 2020/8/31
 */
public class StringVersionCompare {

    //比较版本号
    //v1 = 0.1  v2 = 1.1 return -1
    //v1 = 1.0.1 v2 = 1 return 1
    //v1 = 1.01 v2 = 1.001 return 0 ，忽略前导0， 01 = 001
    private static int compare(String v1, String v2) {
        return 1;
    }
}
