package class034;

public class Test034_01 {
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        int diff = 0;
        while (a.next != null) {
            diff++;
            a = a.next;
        }
        while (b.next != null) {
            diff--;
            b = b.next;
        }
        if (a != b) {
            return null;
        }
        if (diff > 0) {
            a = headA;
            b = headB;
        } else {
            a = headB;
            b = headA;
        }
        diff = Math.abs(diff);
        while (diff > 0) {
            diff--;
            a = a.next;
        }
        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }
}
