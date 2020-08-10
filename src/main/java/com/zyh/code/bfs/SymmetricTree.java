package com.zyh.code.bfs;

import com.zyh.code.tree.Support;

/**
 * @author zhangyinghui  Date: 2020/8/10 Time: 9:12 PM
 */
public class SymmetricTree {
    // Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

// For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
// But the following [1,2,2,null,3,null,3] is not:
//     1
//    / \
//   2   2
//    \   \
//    3    3

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    //解法: 广度优先搜索
    public static void main(String[] args) {
        Support.TreeNode root = Support.buildTree();
        boolean result = isSymmetricTree(root);
        System.out.println(result);
    }

    private static boolean isSymmetricTree(Support.TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricTree0(root.getLeft(), root.getRight());
    }

    private static boolean isSymmetricTree0(Support.TreeNode left, Support.TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if(left == null || right == null || left.getValue() != right.getValue()) {
            return false;
        }
        return isSymmetricTree0(left.getLeft(), right.getRight()) && isSymmetricTree0(left.getRight(), right.getLeft());
    }
}
