package com.zyh.code.array;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author yinghui.zhang on 2020/8/7
 */
public class MajorityElement {
    //Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
    //You may assume that the array is non-empty and the majority element always exist in the array.

    public static void main(String[] args) {
        int[] array = new int[]{3,3,3,5,3,3,9,2,2};
        int one = findTheElemment(array);
        System.out.println(one);

    }

    private static int findTheElemment(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        Map<Integer, Integer> element2Count = Maps.newHashMap();
        for (int i : array) {

            if (element2Count.containsKey(i)) {
                int count = element2Count.get(i) + 1;
                element2Count.put(i, count);
            } else {
                element2Count.put(i, 1);
            }
            if (element2Count.get(i) > array.length/2) {
                return i;
            }
        }

        return -1;
    }
}
