package com.zyh.code.bit;

/**
 * @author zhangyinghui  Date: 2020/8/15 Time: 5:13 PM
 */
public class CountingBits {
    // Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
    // Example:
    // For num = 5 you should return [0,1,1,2,1,2].
    // see https://www.cnblogs.com/grandyang/p/5294255.html

    /**
     0    0000    0
     -------------
     1    0001    1
     -------------
     2    0010    1
     3    0011    2
     -------------
     4    0100    1
     5    0101    2
     6    0110    2
     7    0111    3
     -------------
     8    1000    1
     9    1001    2
     10   1010    2
     11   1011    3
     12   1100    2
     13   1101    3
     14   1110    3
     15   1111    4
     * @param args
     */
    //可以认为是个规律题
    public static void main(String[] args) {
        int n = 5;
        int[] bits = new int[n+1];
        bits[0]=0;
        for (int i =1 ;i <= n; i++) {
            bits[i] = bits[i&(i-1)] + 1;
        }
        System.out.println(bits);
    }
}
