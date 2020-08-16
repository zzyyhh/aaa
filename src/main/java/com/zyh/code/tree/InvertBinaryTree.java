package com.zyh.code.tree;

import com.zyh.code.support.TreeNode;

import static com.zyh.code.support.Support.buildTree;

/**
 *
 * @author yinghui.zhang on 2020/8/3
 */
public class InvertBinaryTree {

    /**
     * the binary tree
     *    4
     *  /  \
     * 2    6
     *
     * invert the result is
     *    4
     *  /  \
     * 6    2
     *
     * 解法：递归
     *
     */

    public static void main(String[] args) {
        TreeNode root = buildTree();
        invertBinaryTree(root);
        System.out.println(root);


        //2
        TreeNode result = invertBinaryTree2(root);
        System.out.println(result);



    }

    private static void invertBinaryTree3(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode leftTemp = root.left;
        root.left = root.right;
        root.right = leftTemp;
        invertBinaryTree3(root.left);
        invertBinaryTree3(root.right);
    }



    private static void invertBinaryTree(TreeNode root) {
        //基线条件
        if (root == null) {
            return;
        }
        //递归条件
        TreeNode left = root.left;
        TreeNode right = root.right;
        //交换
        root.right = left;
        root.left = right;
        //递归
        invertBinaryTree(root.right);
        invertBinaryTree(root.left);
    }

    private static TreeNode invertBinaryTree2(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = invertBinaryTree2(left);
        root.left = invertBinaryTree2(right);
        return root;
    }


}
