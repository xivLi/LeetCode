public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode mid = head;
        ListNode tail = head;
        while (tail != null && tail.next != null) {
            mid = mid.next;
            tail = tail.next;
            if (tail != null) {
                tail = tail.next;
            }
        }

        return mid;
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