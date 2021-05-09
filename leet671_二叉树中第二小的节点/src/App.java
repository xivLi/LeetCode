import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int min = -1;
        while (!list.isEmpty()) {
            TreeNode tn = list.poll();
            if (tn.left != null) {
                if (tn.left.val > tn.val) {
                    if (min == -1) {
                        min = tn.left.val;
                    } else {
                        min = Math.min(min, tn.left.val);
                    }
                } else {
                    list.add(tn.left);
                }
            }
            if (tn.right != null) {
                if (tn.right.val > tn.val) {
                    if (min == -1) {
                        min = tn.right.val;
                    } else {
                        min = Math.min(min, tn.right.val);
                    }
                } else {
                    list.add(tn.right);
                }
            }
        }
        return min;
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