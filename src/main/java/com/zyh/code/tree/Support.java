package com.zyh.code.tree;

/**
 * @author yinghui.zhang on 2020/8/3
 */
public class Support {
    public static TreeNode buildTree() {
        TreeNode left = new TreeNode(2, null, null);
        TreeNode right = new TreeNode(6, null, null);
        TreeNode root = new TreeNode(4, left, right);
        return root;
    }

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

}
