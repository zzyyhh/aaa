package com.zyh.code.tree;

import com.google.common.collect.Lists;
import com.zyh.code.support.Support;
import com.zyh.code.support.TreeNode;

import java.util.List;

/**
 * @author yinghui.zhang on 2020/8/3
 */
public class BinaryTreePaths {

    private static void main0() {

        // Given a binary tree, return all root-to-leaf paths.

        //    1
        //  /   \
        // 2     3
        //  \
        //   5
        // All root-to-leaf paths are:
        // ["1->2->5", "1->3"]

       List<String> result = binaryTreePaths0(Support.buildTree());
    }

    private static List<String> binaryTreePaths0(TreeNode treeNode) {
        List<String> result = Lists.newArrayList();
        if (treeNode == null) {
            return result;
        }
        path0("", result, treeNode);
        return result;
    }

    private static void path0(String current, List<String> result, TreeNode treeNode) {
        if (treeNode.left == null && treeNode.right == null) {
            result.add(current+treeNode.value);
        }
        if (treeNode.left != null) {
            path0(current+treeNode.value +"->", result, treeNode.left);
        }
        if (treeNode.right != null) {
            path0(current+treeNode.value+"->",result,treeNode.right);
        }
    }


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
        main0();
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
