package com.company.lesson17.singly_linked_list;

public class Main {
    public static void main(String[] args) {
        ListNode nodes = new ListNode(
                1, new ListNode(
                2, new ListNode(
                3, new ListNode(
                4, null))));
        Solution solution = new Solution();
        System.out.println(solution.reverseList(nodes));
    }
}
