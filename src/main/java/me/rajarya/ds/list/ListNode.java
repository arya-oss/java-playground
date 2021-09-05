package me.rajarya.ds.list;

public class ListNode {
    int data;
    ListNode next;
    public ListNode() {}
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
    public  ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public void print() {
        ListNode curr = this;
        while (curr != null) {
            System.out.print(" -> " + curr.data);
            curr = curr.next;
        }
    }
}