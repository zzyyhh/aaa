package com.zyh.code.math;

/**
 * @author yinghui.zhang on 2020/8/4
 */
public class AddDigits {
    public static void main(String[] args) {
        //Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

        //For example:
        //Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

        //Follow up:
        //Could you do it without any loop/recursion in O(1) runtime?
        addDigits(38);
    }

    private static int addDigits(int num) {
        // 依次循环
        while (num >= 10) {
            int  tmp = 0;
            // add every bit
            while (num > 0) {
                tmp += num % 10;
                num /= 10;
            }
            num = tmp;
        }
        return num;
    }
}
