public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 交换左右孩子
        exChild(root);
        return root;
    }

    private void exChild(TreeNode root) {
        TreeNode tn = root.left;
        root.right = root.left;
        root.left = tn;
        if (root.left != null) {
            exChild(root.left);
        }
        if (root.right != null) {
            exChild(root.right);
        }
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