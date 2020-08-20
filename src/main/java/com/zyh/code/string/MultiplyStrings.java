package com.zyh.code.string;

/**
 * @author yinghui.zhang on 2020/8/4
 */
public class MultiplyStrings {
    // Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

    // Note:

    // The length of both num1 and num2 is < 110.
    // Both num1 and num2 contains only digits 0-9.
    // Both num1 and num2 does not contain any leading zero.
    // You must not use any built-in BigInteger library or convert the inputs to integer directly.
    // string 相乘
    // 解法：提前留位，按个相乘
    // leetcode  https://leetcode.com/problems/multiply-strings/discuss/762851/Java-simple-solution

    public static void main(String[] args) {
        String result = product("123","456");
        System.out.println(result);
    }

    private static String product(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
