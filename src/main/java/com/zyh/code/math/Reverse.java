package com.zyh.code.math;

/**
 * @author zhangyinghui  Date: 2020/9/9 Time: 4:33 PM
 */
public class Reverse {
//    https://leetcode-cn.com/problems/reverse-integer/

    public int reverse(int x) {


        int result = 0;
        while (x!=0) {

            int temp = x%10;

            //判断是否 大于 最大32位整数
            if (result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && temp>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (result<-Integer.MAX_VALUE/10 || (result==-Integer.MAX_VALUE/10 && temp<-8)) {
                return 0;
            }

            x=x/10;
            result=result*10+temp;
        }
        return result;
    }

}
