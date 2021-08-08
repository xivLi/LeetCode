import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
    }
}

// 递归
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        preorder(root, ans);
        return ans;
    }

    private void preorder(Node root, List<Integer> ans) {
        ans.add(root.val);
        List<Node> children = root.children;
        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                preorder(children.get(i), ans);
            }
        }
    }

}

// 非递归
class Solution2 {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ans.add(node.val);
            List<Node> children = node.children;
            if (children != null) {
                // for (int i = children.size() - 1; i >= 0; i--) {
                // stack.push(children.get(i));
                // }
                // 仙术
                Collections.reverse(children);
                children.forEach(child -> {
                    stack.push(child);
                });
            }
        }

        return ans;
    }
}