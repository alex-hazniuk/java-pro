package com.company.lesson17.singly_linked_list;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode tail = null;
        ListNode node;
        while (head != null) {
            node = head.next;
            head.next = tail;
            tail = head;
            head = node;
        }
        return tail;
    }
}
