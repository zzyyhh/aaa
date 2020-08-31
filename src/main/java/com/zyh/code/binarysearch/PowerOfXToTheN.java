package com.zyh.code.binarysearch;

/**
 * @author zhangyinghui  Date: 2020/8/10 Time: 9:35 PM
 */
public class PowerOfXToTheN {
    // Implement pow(x, n).

    public static void main(String[] args) {
        double result = pow(2, 10);
        System.out.println(result);
    }

    private static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (Double.isInfinite(x)) {
            return 0;
        }

        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        if (n % 2 == 0) {
            return pow(x*x, n/2);
        } else {
            return x * pow(x*x, n/2);
        }
    }
    private static double pow1(double x, int n) {
       //x的n次方
        if (n == 0) {
            return 1;
        }
        if (Double.isInfinite(x)) {
            return 0;
        }
        if (n < 0) {
            n = -n;
            x = 1/x;
        }

        if(n%2==0){
            return pow(x*x, n/2);
        } else {
            return x * pow(x*x, n/2);
        }

    }
}
