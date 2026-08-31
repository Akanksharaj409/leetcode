/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode curr = head.next;
        ListNode prev = head;
        ListNode Next = head.next.next;

        int first = -1;
        int last = -1;
        int minDistance = Integer.MAX_VALUE;

        int idx = 1;
        while(curr != null && curr.next != null) {
            ListNode next = curr.next;
            if((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)) {
                if(first == -1) {
                    first = idx;
                } else {
                    minDistance = Math.min(minDistance, idx - last);
                }
                last = idx;
            }
            prev = curr;
            curr = next;
            idx++;
        }
        
        if(first == last) {
            return new int[] {-1, -1};
        }
        return new int[] {minDistance, last-first};
    }
}