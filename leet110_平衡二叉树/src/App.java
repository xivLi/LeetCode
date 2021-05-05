public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    private boolean ans;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        ans = true;
        check(root);
        return ans;
    }

    private void check(TreeNode root) {
        int left = calHigh(root.left);
        int right = calHigh(root.right);
        if (Math.abs(left - right) > 1) {
            ans = false;
        }
        if (ans && root.left != null) {
            check(root.left);
        }
        if (ans && root.right != null) {
            check(root.right);
        }

    }

    private int calHigh(TreeNode node) {
        if (node == null)
            return 0;
        else
            return Math.max(calHigh(node.left), calHigh(node.right)) + 1;
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