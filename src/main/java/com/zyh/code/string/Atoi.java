package com.zyh.code.string;

/**
 * @author zhangyinghui  Date: 2020/8/18 Time: 11:26 PM
 */
public class Atoi {
    public static void main(String[] args) {
        String a = "112";
        if (a == null || a.length() == 0) {
            return;
        }
        int sum = 0;
        int length = a.length();
        for (int i = 0; i < length ;i++) {
            sum = sum * 10 + (a.charAt(i) - '0') ;
        }
        System.out.println(sum);
    }
}
