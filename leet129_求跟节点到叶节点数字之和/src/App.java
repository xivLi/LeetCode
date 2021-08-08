
public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
    }
}

class Solution {
    private int sum;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        if (root != null) {
            bianli(root, root.val);
        }

        return sum;
    }

    private void bianli(TreeNode root, int val) {
        if (root.left == null && root.right == null) {
            sum += val;
        } else {
            if (root.left != null) {
                bianli(root.left, val * 10 + root.left.val);
            }
            if (root.right != null) {
                bianli(root.right, val * 10 + root.right.val);
            }
        }
    }
}