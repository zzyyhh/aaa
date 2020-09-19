package com.zyh.code.bit;

/**
 * @author zhangyinghui  Date: 2020/8/16 Time: 9:00 PM
 */
public class NumberOfOneBits {
    // Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

    // For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

    public static void main(String[] args) {
        int n = 11;
        int result = num(n);
        System.out.println(result);
    }

    private static int num(int n) {
        int result = 0;
        while (n != 0) {
            result=+(1&n);
            n=n>>>1;
        }
        return result;
    }


//    private static int num(int n) {
//        int result = 0;
//        if (n == 0) {
//            return result;
//        }
//        while (n != 0) {
//            result = (1 & (n)) + result;
//            n = n >>> 1;
//        }
//        return result;
//    }
//

}
