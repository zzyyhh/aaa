package com.zyh.code.tree;

import com.zyh.code.tree.Support.TreeNode;

/**
 * @author yinghui.zhang on 2020/8/3
 */
public class BinaryTreeMaximumPathSum_No {
    // Given a binary tree, find the maximum path sum.

    // For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
    // The path must contain at least one node and does not need to go through the root.

    // For example:
    // Given the below binary tree,

    //        1
    //       / \
    //      2   3
    // Return 6.

    // from : https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
    // 解法：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/shou-hui-tu-jie-hen-you-ya-de-yi-dao-dfsti-by-hyj8/
    // dfs
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int result = findMax(Support.buildTree());
        System.out.println(result);
    }

    private static int findMax(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = Math.max(findMax(treeNode.left),0);
        int right = Math.max(findMax(treeNode.right), 0);
        max = Math.max(max, treeNode.value + left+ right);
        return treeNode.value + Math.max(left, right);
    }
}
