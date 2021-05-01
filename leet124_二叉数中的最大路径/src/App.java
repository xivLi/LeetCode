
public class App {
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution so = new Solution();
        so.maxPathSum(root);
    }
}

class Solution {
    private int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);

        return maxValue;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftGain = Math.max(dfs(node.left), 0);

        int rightGain = Math.max(dfs(node.right), 0);
        int val = node.val + leftGain + rightGain;

        if (val > maxValue) {
            maxValue = val;
        }
        return node.val + Math.max(leftGain, rightGain);
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