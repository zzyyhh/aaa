package com.zyh.code.bit;

/**
 * @author zhangyinghui  Date: 2020/8/15 Time: 9:19 PM
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
        int n = 128;
        boolean result = isPowerOfTwo(n);
        System.out.println(result);
    }

    private static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        int i = 1;
        while (i < n) {
            i<<=1;
        }
        return i == n;
    }

}
