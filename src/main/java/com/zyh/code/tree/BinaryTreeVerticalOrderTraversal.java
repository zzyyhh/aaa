package com.zyh.code.tree;

import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import com.google.common.collect.Lists;
import com.zyh.code.support.Support;
import com.zyh.code.support.TreeNode;

/**
 * @author yinghui.zhang on 2020/8/27
 */
public class BinaryTreeVerticalOrderTraversal {

    // Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

    // If two nodes are in the same row and column, the order should be from left to right.

    // Examples:

    // Given binary tree [3,9,20,null,null,15,7],
    //    3
    //   /\
    //  /  \
    //  9  20
    //     /\
    //    /  \
    //   15   7
    // return its vertical order traversal as:
    // [
    //   [9],
    //   [3,15],
    //   [20],
    //   [7]
    // ]

    //解法:按照层遍历,使用map存储,key为index(root为0,左边为负数,右边为整数,使用treeMap有序)
    //leetcode 314 https://www.cnblogs.com/grandyang/p/5278930.html
    public static void main(String[] args) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        TreeNode root = Support.buildTree1();
        if (root == null) {
            return;
        }
        map.put(0, Lists.newArrayList(root.value));
        vot(root,map,0);
        System.out.println(map);
    }

    private static void vot(TreeNode root, TreeMap<Integer, List<Integer>> map, int index) {
        int leftIndex = index -1 ;
        int rightIndex = index + 1;


        if (root.left != null) {
            if (map.containsKey(leftIndex)) {
                map.get(leftIndex).add(root.left.value);
            } else {
                map.put(leftIndex, Lists.newArrayList(root.left.value));
            }
            vot(root.left, map, leftIndex);
        }

        if (root.right != null) {
            if (map.containsKey(rightIndex)) {
                map.get(rightIndex).add(root.right.value);
            } else {
                map.put(rightIndex, Lists.newArrayList(root.right.value));
            }
            vot(root.right, map, rightIndex);
        }
    }
}
