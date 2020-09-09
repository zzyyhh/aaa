package com.zyh.code.tree;

import com.google.common.collect.Lists;
import com.zyh.code.support.Support;
import com.zyh.code.support.TreeNode;

import java.util.List;
import java.util.Queue;

/**
 * @author yinghui.zhang on 2020/8/20
 */
public class LastLeftNode {
    //打印二叉树最后一层最左节点

    // Example:

    //     3
    //    / \
    //   9   20
    //      /  \
    //     15   7

    public static void main(String[] args) {
        TreeNode treeNode = Support.buildTree1();
        Integer result = findLastLevelLeftNode(treeNode);
        System.out.println(result);
    }


    //解法1. 按层遍历,

    private static Integer findLastLevelLeftNode(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
//        Map<Integer, List<Integer>> level2Nodes = Maps.newHashMap();
        int level = 0;
        Queue<TreeNode> queue = Lists.newLinkedList();
        queue.add(treeNode);

        List<Integer> leftList = Lists.newArrayList();

        while (queue.size() > 0) {
            level++;
            int size = queue.size();
            List<Integer> temp = Lists.newArrayList();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.getValue());

                if (node.left != null) {
                    queue.add(node.left);
                    leftList.add(node.left.value);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

//            level2Nodes.put(level, temp);
        }


        return leftList.get(leftList.size()-1);
    }
}
