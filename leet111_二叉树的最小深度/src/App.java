import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public int minDepth(TreeNode root) {
        // 逐层遍历，找到第一个叶子节点
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        list.offer(root);
        list2.offer(1);
        int depth = 1;
        while (!list.isEmpty()) {
            TreeNode tn = list.poll();
            depth = list2.poll();
            if (tn.left == null && tn.right == null) {
                break;
            } else {
                if (tn.left != null) {
                    list.offer(tn.left);
                    list2.offer(depth + 1);
                }

                if (tn.right != null) {
                    list.offer(tn.right);
                    list2.offer(depth + 1);
                }
            }
        }

        return depth;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}