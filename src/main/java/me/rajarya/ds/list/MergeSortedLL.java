package me.rajarya.ds.list;

public class MergeSortedLL {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(3);
//        l1.next.next = new ListNode(7);

        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(5);

        ListNode l3 = merge(l1, l2);

        l3.print();
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode head = null;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                if (l3 == null) {
                    l3 = new ListNode(l1.data);
                    head = l3;
                } else {
                    l3.next = new ListNode(l1.data);
                    l3 = l3.next;
                }
                l1 = l1.next;
            } else {
                if (l3 == null) {
                    l3 = new ListNode(l2.data);
                    head = l3;
                } else {
                    l3.next = new ListNode(l2.data);
                    l3 = l3.next;
                }
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            l3.next = new ListNode(l1.data);
            l1 = l1.next;
            l3 = l3.next;
        }

        while (l2 != null) {
            l3.next = new ListNode(l2.data);
            l2 = l2.next;
            l3 = l3.next;
        }

        return head;
    }
}
