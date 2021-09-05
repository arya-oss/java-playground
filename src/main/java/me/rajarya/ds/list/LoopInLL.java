package me.rajarya.ds.list;

public class LoopInLL {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = head.next.next;

        boolean isLoop = detectLoop(head);
        System.out.println("is loop: " + isLoop);
    }

    private static boolean detectLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
