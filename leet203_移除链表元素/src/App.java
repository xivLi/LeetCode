public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null) {
            if (head.val == val) {
                head = head.next;
            } else {
                break;
            }
        }
        if (head == null) {
            return null;
        }
        ListNode p = head.next;
        ListNode q = head;
        while (p != null) {
            if (p.val == val) {
                q.next = p.next;

            } else {
                q = p;
            }
            p = p.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}