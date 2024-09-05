package Leetcode.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class LevelOrderTraversal {

    private List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();
        if(root == null) return wrapList;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i=0; i<levelNum; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                subList.add(node.val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}

