package com.zyh.code.bit;

/**
 * @author zhangyinghui  Date: 2020/8/16 Time: 6:44 PM
 */
public class HammingDistance {

    // The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

    // Given two integers x and y, calculate the Hamming distance.

    // Note:
    // 0 ≤ x, y < 2^31.

    // Example:

    // Input: x = 1, y = 4

    // Output: 2

    // Explanation:
    // 1   (0 0 0 1)
    // 4   (0 1 0 0)
    //        ↑   ↑

    // The above arrows point to positions where the corresponding bits are different.
    // 汉明距离,同位值不同的个数
    // 解法: 异或 获取 结果数据, 然后统计1的个数
    public static void main(String[] args) {
        System.out.println(Integer.bitCount(1));
        System.out.println(Integer.bitCount(2));
        System.out.println(Integer.bitCount(3));
        //
        int x=1, y=4;

        System.out.println(Integer.bitCount(x ^ y));
    }
}
