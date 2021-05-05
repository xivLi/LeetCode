public class App {
    public static void main(String[] args) throws Exception {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        Solution so = new Solution();
        so.addTwoNumbers(l1, l2);
    }
}

// 链表长度对齐
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jin = 0;
        ListNode p = l1;
        ListNode q = l2;
        ListNode last = l1;

        while (!(p.next == null && q.next == null)) {
            if (p.next == null) {
                p.next = new ListNode(0);
            } else if (q.next == null) {
                q.next = new ListNode(0);
            }
            q = q.next;
            p = p.next;
        }
        p = l1;
        q = l2;
        while (p != null) {
            int val = p.val + q.val + jin;
            if (val > 9) {
                jin = 1;
                val -= 10;
            } else {
                jin = 0;
            }
            p.val = val;
            last = p;
            p = p.next;
            q = q.next;
        }
        if (jin == 1) {
            last.next = new ListNode(1);
        }
        return l1;
    }
}