import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        // 把节点放入 Set 集合，重复即有环
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;

            }
            head = head.next;
        }
        return false;
    }
}

class Solution2 {
    public boolean hasCycle(ListNode head) {
        // 快慢指针
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}