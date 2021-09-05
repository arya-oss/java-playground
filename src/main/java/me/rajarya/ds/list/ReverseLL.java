package me.rajarya.ds.list;

public class ReverseLL {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);

        ListNode newHead = reverse(head);
        print(newHead);
    }

    private static void print(ListNode newHead) {
        while (newHead != null) {
            System.out.print(" -> " + newHead.data);
            newHead = newHead.next;
        }
    }

    private static ListNode reverse(ListNode node) {
        ListNode next, prev = null;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
