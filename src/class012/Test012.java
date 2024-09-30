package class012;

public class Test012 {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = null;
        ListNode leftTail = null;
        ListNode rightHead = null;
        ListNode rightTail = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < x) {
                if (leftHead == null) {
                    leftHead = head;
                } else {
                    leftTail.next = head;
                }
                leftTail = head;
            } else {
                if (rightHead == null) {
                    rightHead = head;
                } else {
                    rightTail.next = head;
                }
                rightTail = head;
            }
            head = next;
        }
        if (leftHead == null) {
            return rightHead;
        }
        leftTail.next = rightHead;
        return leftHead;

    }
}
