package com.zyh.code.tree;

import com.zyh.code.support.TreeNode;

import java.util.*;

/**
 * @author zhangyinghui  Date: 2020/9/9 Time: 4:11 PM
 */
public class RightSideView {
    //    https://leetcode-cn.com/problems/binary-tree-right-side-view/
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Map<Integer, List<Integer>> result = new HashMap<>();
        Integer level = 0;

        while (queue.size() > 0) {
            int size = queue.size();
            level++;
            result.put(level, new ArrayList<>());
            for (int i = 0; i < size ;i++) {
                TreeNode node = queue.poll();
                result.get(level).add(node.value);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

        }
        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : result.entrySet()) {
            List<Integer> tempList = entry.getValue();
            if (tempList != null && tempList.size() != 0) {
                resultList.add(tempList.get(tempList.size()-1));
            }
        }

        return resultList;

    }
}



