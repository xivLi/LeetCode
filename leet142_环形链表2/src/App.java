import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}

class Solution2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;

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