public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        so.swapPairs(head);
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        // 前两个节点单独处理 如: [1 2 3]
        ListNode tail = head; // tail: 1
        head = head.next; // head: 2
        tail.next = head.next; // tail.next: 3
        head.next = tail; // head.next: 1

        // 提供tail, tail.next, tail.next.next三个节点进行交换操作, 交换tail.next与tail.next.next
        // 要求tail.next和tail.next.next两个节点存在
        ListNode p = tail.next;

        while (p != null && p.next != null) {
            ListNode q = p.next;
            // 交换
            p.next = q.next;
            tail.next = q;
            q.next = p;
            // 更新tail, 进行下一波循环
            tail = p;
            p = tail.next;
        }

        return head;
    }
}