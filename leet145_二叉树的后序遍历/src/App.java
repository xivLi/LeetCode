import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) { // 迭代考虑root节点的左孩子 直到没有左孩子 则 处理这样的节点
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.right == null || root.right == pre) { // 节点没有右子数或者节点右孩子已经被访问 则 访问该节点
                ans.add(root.val);
                pre = root;
                root = null; // root设置为null 这样可以 下轮循环直接取栈顶元素
            } else {
                stack.push(root); // root有右子树 且 未被访问 则 重新入栈 且 将root设置为右孩子进入下轮循环
                root = root.right;
            }
        }

        return ans;
    }
}