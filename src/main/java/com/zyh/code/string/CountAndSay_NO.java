package com.zyh.code.string;

/**
 * @author yinghui.zhang on 2020/8/4
 */
public class CountAndSay_NO {
    // The count-and-say sequence is the sequence of integers beginning as follows:
    // 1, 11, 21, 1211, 111221, ...

    // 1 is read off as "one 1" or 11.
    // 11 is read off as "two 1s" or 21.
    // 21 is read off as "one 2, then one 1" or 1211.
    // Given an integer n, generate the nth sequence.

    // Note: The sequence of integers will be represented as a string.

    /**
     * 本质是递归的逻辑去解，或者循环去解，关键在char/count
         1. 1
         2. 11
         3. 21
         4. 1211
         5. 111221
     * @param args
     * leetcode https://leetcode-cn.com/problems/count-and-say/solution/1-ms-zai-suo-you-java-ti-jiao-zhong-ji-bai-liao-97/
     */

    public static void main(String[] args) {
        //
        int i = 5;
        String result =  countAndSay(i);
        System.out.println(result);
    }

    private static String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++) {
            //一个一个数的计算
            s = helper(s);
        }
        return s;
    }

    private static String helper(String s) {
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == c) {
                count++;
            } else {
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}
