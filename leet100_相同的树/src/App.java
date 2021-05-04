import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
    }
}

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
// 使用 队列 层次遍历树
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        LinkedList<TreeNode> queueP = new LinkedList<>();
        LinkedList<TreeNode> queueQ = new LinkedList<>();
        queueP.offer(p);
        queueQ.offer(q);
        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            TreeNode tp = queueP.poll();
            TreeNode tq = queueQ.poll();
            if (tp.val != tq.val)
                return false;
            if (tp.left != null && tq.left == null || tp.left == null && tq.left != null) {
                return false;
            }
            if (tp.right != null && tq.right == null || tp.right == null && tq.right != null) {
                return false;
            }
            if (tp.left != null && tq.left != null) {
                queueP.offer(tp.left);
                queueQ.offer(tq.left);
            }
            if (tp.right != null && tq.right != null) {
                queueP.offer(tp.right);
                queueQ.offer(tq.right);
            }

        }
        if (queueP.isEmpty() && queueQ.isEmpty()) {
            return true;
        }
        return false;
    }
}