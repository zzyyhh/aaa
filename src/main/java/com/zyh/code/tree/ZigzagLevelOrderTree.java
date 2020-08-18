package com.zyh.code.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zyh.code.support.Support;
import com.zyh.code.support.TreeNode;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *  3
 * / \
 * 9  20
 *   /  \
 *  15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 *
 * @author yinghui.zhang on 2020/8/18
 */
public class ZigzagLevelOrderTree {
    public static void main(String[] args) {
        TreeNode treeNode = Support.buildTree1();

        //普通遍历
        traverse(treeNode);

        //按层遍历
        Map<Integer, List<Integer>> index2Elements = Maps.newHashMap();
        if (treeNode == null) {
            return;
        }
        index2Elements.put(1, Lists.newArrayList(treeNode.value));
        layerTraverse(treeNode, index2Elements, 1);
        System.out.println(index2Elements);
    }


    public List<List<Integer>> levelOrder0(TreeNode root) {
        if (root == null) {
            return Lists.newArrayList();
        }
        List<List<Integer>>  result = Lists.newArrayList();
        LinkedList<TreeNode> queue = Lists.newLinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {

            List<Integer> temp = Lists.newArrayList();
            int size = queue.size();
            for (int i = 0; i< size; i++) {
                TreeNode treeNode = queue.remove();
                temp.add(treeNode.value);
                if (treeNode.left !=null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right !=null) {
                    queue.add(treeNode.right);
                }
            }
            result.add(temp);
        }
        return result;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        //将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while(queue.size()>0) {
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            //如果节点的左/右子树不为空，也放入队列中
            for(int i=0;i<size;++i) {
                TreeNode t = queue.remove();
                tmp.add(t.value);
                if(t.left!=null) {
                    queue.add(t.left);
                }
                if(t.right!=null) {
                    queue.add(t.right);
                }
            }
            //将临时list加入最终返回结果中
            res.add(tmp);
        }
        return res;
    }


    private static void layerTraverse(TreeNode treeNode,  Map<Integer, List<Integer>> index2Elements, int layer) {
        //dfs
        if (treeNode.left != null) {
            int leftLayer = layer + 1;
            if (index2Elements.get(leftLayer) == null) {
                index2Elements.put(leftLayer, Lists.newArrayList());
            }
            index2Elements.get(leftLayer).add(treeNode.left.value);
            layerTraverse(treeNode.left, index2Elements, leftLayer);
        }
        if (treeNode.right != null) {
            int rightLayer = layer +1;
            if (index2Elements.get(rightLayer) == null) {
                index2Elements.put(rightLayer, Lists.newArrayList());
            }
            index2Elements.get(rightLayer).add(treeNode.right.value);
            layerTraverse(treeNode.right, index2Elements, rightLayer);
        }
    }

    private static void traverse(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        traverse(treeNode.right);
        System.out.println(treeNode.value);
        traverse(treeNode.left);
    }
}
