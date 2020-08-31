package com.zyh.company.kuaishou;

/**
 * @author zhangyinghui  Date: 2020/8/31 Time: 8:21 PM
 */
public class MergeArray {
    /**
     * 输入:
     * nums1 = [1,2,3], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * 输出: [1,2,2,3,5,6]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array
     */

    private static int[] merge(int[] array1, int[] array2) {
        if (array1 == null || array1.length == 0) {
            return array2;
        }
        if (array2 == null || array2.length == 0) {
            return array1;
        }
        int array1Length = array1.length;
        int array2Length = array2.length;
        int[] result = new int[array1Length + array2Length];

        //空间复杂度m+n
        int i = 0;
        int j = 0;
        int p = 0;
        while (i < array1Length && j < array2Length) {
            //both i && j
            if (array1[i] >= array2[j]) {
                result[p] = array2[j];
                j++;
            } else {
                result[p] = array1[i];
                i++;
            }
            p++;
        }
        if (i < array1Length ) {
            System.arraycopy(array1, i, result, p, array1Length - i);
        }
        if (j < array2Length ) {
            System.arraycopy(array2, array2[p], result, p, array2Length - j);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] result = merge(new int[]{1,3,5}, new int[]{2,4});
        System.out.println(result);
    }
}
