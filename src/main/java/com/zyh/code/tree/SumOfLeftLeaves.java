package com.zyh.code.tree;

import com.google.common.collect.Lists;
import com.zyh.code.support.Support;
import com.zyh.code.support.TreeNode;

import java.util.List;

/**
 * @author yinghui.zhang on 2020/8/3
 */
public class SumOfLeftLeaves {
    // Find the sum of all left leaves in a given binary tree.

    // Example:

    //     3
    //    / \
    //   9  20
    //     /  \
    //    15   7

    // There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

    // 解法：递归，临时List
    public static void main(String[] args) {
        TreeNode treeNode = Support.buildTree();
        treeNode.left = Support.buildTree();

        int result = sumOfLeftLeaves(treeNode);
        System.out.println(result);
    }


    private static void sumOfLeft0(List<Integer> sum , TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            sum.add(root.left.value);
        }
        sumOfLeft0(sum, root.left);
        sumOfLeft0(sum, root.right);
    }

    private static int sumOfLeftLeaves(TreeNode treeNode) {
        List<Integer> integers = Lists.newArrayList();
        if (treeNode == null) {
            return 0;
        }
        sumOfLeft(integers, treeNode);
        return integers.stream().mapToInt(integer -> integer).sum();
    }

    private static void sumOfLeft(List<Integer> integers, TreeNode treeNode) {
        if (treeNode.left == null) {
            return;
        }
        integers.add(treeNode.left.value);
        sumOfLeft(integers, treeNode.left);
        sumOfLeft(integers, treeNode.right);
    }
}
