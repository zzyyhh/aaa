package com.zyh.code.tree;

import java.util.List;

import com.google.common.collect.Lists;
import com.zyh.code.tree.Support.TreeNode;

/**
 * @author yinghui.zhang on 2020/8/3
 */
public class BinaryTreePaths {

    public static void main(String[] args) {

        // Given a binary tree, return all root-to-leaf paths.

        //    1
        //  /   \
        // 2     3
        //  \
        //   5
        // All root-to-leaf paths are:
        // ["1->2->5", "1->3"]

        // 解法：递归，临时


        List<String> result = binaryTreePaths(Support.buildTree());
        System.out.println(result);
    }

    private static List<String> binaryTreePaths(TreeNode treeNode) {

        List<String> result = Lists.newArrayList();
        if (treeNode ==null) {
            return result;
        }
        path("", result, treeNode);
        return result;
    }

    private static void path(String current, List<String> result, TreeNode treeNode) {
        if (treeNode.left == null && treeNode.right == null) {
            result.add(current+treeNode.value);
        }

        if (treeNode.left != null) {
            path(current+treeNode.value+"->", result, treeNode.left);
        }
        if (treeNode.right != null) {
            path(current+treeNode.value+"->", result, treeNode.right);
        }

    }
}
