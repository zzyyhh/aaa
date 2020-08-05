package com.zyh.code.math;

/**
 * @author yinghui.zhang on 2020/8/4
 */
public class PowerOfTwo {
    //Given an integer, write a function to determine if it is a power of two.
    //
    //Example 1:
    //
    //Input: 1
    //Output: true
    //Example 2:
    //
    //Input: 16
    //Output: true
    //Example 3:
    //
    //Input: 218
    //Output: false

    public static void main(String[] args) {
        boolean result = powerOfTwo(16);
    }

    private static boolean powerOfTwo(int n) {
        //即二进制最高位为1
        int i = 1;
        while (i < n) {
            i = i << 1;
        }
        return i == n;
    }
}
