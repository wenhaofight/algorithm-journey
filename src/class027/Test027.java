package class027;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test027 {
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode head = heap.poll();
        ListNode pre = head;
        if (pre.next != null) {
            heap.add(pre.next);
        }
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            if (cur.next != null) {
                heap.add(cur.next);
            }
            pre.next = cur;
            pre = cur;
        }
        return head;
    }
}

