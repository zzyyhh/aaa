package com.zyh.code.tree;

import com.google.common.collect.Lists;
import com.zyh.code.support.Support;
import com.zyh.code.support.TreeNode;

import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * @author zhangyinghui  Date: 2020/8/11 Time: 11:14 PM
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
// Given binary tree [3,9,8,4,0,1,7],
//      3
//     /\
//    /  \
//    9   8
//   /\  /\
//  /  \/  \
//  4  01   7
// return its vertical order traversal as:
// [
//   [4],
//   [9],
//   [3,0,1],
//   [8],
//   [7]
// ]
// Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
//      3
//     /\
//    /  \
//    9   8
//   /\  /\
//  /  \/  \
//  4  01   7
//     /\
//    /  \
//    5   2
// return its vertical order traversal as:
// [
//   [4],
//   [9,5],
//   [3,0,1],
//   [8,2],
//   [7]
// ]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
            System.out.println(map);
            return;
        }
        List<Integer> list = Lists.newArrayList(root.getValue());
        map.put(0, list);
        traversal(root, map, 0);
        System.out.println(map);
    }
// Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
//      3
//     /\
//    /  \
//    9   8
//   /\  /\
//  /  \/  \
//  4  01   7
//     /\
//    /  \
//    5   2
// return its vertical order traversal as:
// [
//   [4],
//   [9,5],
//   [3,0,1],
//   [8,2],
//   [7]
// ]
    private static void traversal(TreeNode root, TreeMap<Integer, List<Integer>> map, Integer lastIndex) {
        if (root == null) {
            return;
        }
        Integer rightHigh = lastIndex+1;
        Integer leftHigh = lastIndex-1;
        TreeNode left = root.getLeft();
        TreeNode right = root.getRight();
        if (left != null) {
            if (map.containsKey(leftHigh)) {
                map.get(leftHigh).add(left.getValue());
            } else {
                List<Integer> list = Lists.newArrayList(left.getValue());
                map.put(leftHigh, list);
            }
        }
        if(right != null) {
            if (map.containsKey(rightHigh)) {
                map.get(rightHigh).add(right.getValue());
            } else {
                List<Integer> list = Lists.newArrayList(right.getValue());
                map.put(rightHigh, list);
            }
        }
        traversal(left, map, leftHigh);
        traversal(right, map, rightHigh);
    }
}



























