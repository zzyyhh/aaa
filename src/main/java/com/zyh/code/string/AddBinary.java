package com.zyh.code.string;

/**
 * @author yinghui.zhang on 2020/8/3
 */
public class AddBinary {
    // Given two binary strings, return their sum (also a binary string).

    // For example,
    // a = "11"
    // b = "1"
    // Return "100"
    // 解法：二进制的加法 + for

    public static void main(String[] args) {
        addBinary();
        addBinary1();
    }

    private static void addBinary1() {
        String a = "11";
        String b = "1";
        int aLength = a.length() - 1;
        int bLength = b.length() - 1;
        StringBuilder result = new StringBuilder();

        int temp = 0;
        while (aLength >=0 || bLength >= 0) {
            int sum = temp;
            if (aLength >=0 ) {
                sum += a.charAt(aLength--) - '0';
            }
            if (bLength >= 0) {
                sum += b.charAt(bLength--) - '0';
            }
            result.append(sum%2);
            temp = sum/2;
        }
        if (temp != 0) {
            result.append(temp);
        }
        System.out.printf(result.toString());
    }

    private static void addBinary() {
        int aa = 60;
        System.out.println(aa);
        System.out.println(aa - '0');
        StringBuilder result = new StringBuilder();
        String a = "11";
        String b = "1";
        int i = a.length() - 1;
        int j = b.length() - 1;
        int temp = 0;
        while (i >=0 || j>=0 ) {
            int sum = temp;
            if (i >= 0){
                sum+=a.charAt(i--) - '0';
            }
            if (j >=0) {
                sum += b.charAt(j--) - '0';
            }
            result.append(sum % 2);
            temp = sum/2;
        }
        if (temp != 0) {
            result.append(temp);
        }
        String xx = result.reverse().toString();
        System.out.println(xx);
    }


}
