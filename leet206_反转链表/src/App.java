public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode nHead = head;
        ListNode next = nHead.next;
        nHead.next = null;
        while (next != null) {

            ListNode temp = next.next;
            next.next = nHead;
            nHead = next;
            next = temp;
        }
        return nHead;
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