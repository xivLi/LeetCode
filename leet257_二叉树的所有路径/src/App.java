import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    List<String> ans;

    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        if (root != null) {
            bianli(root, "" + root.val);
        }
        return ans;
    }

    private void bianli(TreeNode root, String string) {
        if (root.left == null && root.right == null) {
            ans.add(string);
            return;
        }
        if (root.left != null) {
            bianli(root.left, string + "->" + root.left.val);
        }
        if (root.right != null) {
            bianli(root.right, string + "->" + root.right.val);
        }
    }

}