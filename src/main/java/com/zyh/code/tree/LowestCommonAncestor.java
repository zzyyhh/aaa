package com.zyh.code.tree;

import com.zyh.code.support.TreeNode;

/**
 * @author zhangyinghui  Date: 2020/8/29 Time: 11:36 PM
 */
public class LowestCommonAncestor {

    //最小公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left!=null&&right==null) {
            return left;
        }
        if (right!=null&&left==null) {
            return right;
        }
        return root;
    }
}
