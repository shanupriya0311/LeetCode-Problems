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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode current=slow.next;
        slow.next=null;
        ListNode prev=null;
        while(current!=null){
            ListNode next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        ListNode l2=prev;
        ListNode l1=head;
       while(l2!=null){
         ListNode l1nxt=l1.next;
         ListNode l2nxt=l2.next;
         l1.next=l2;
         l2.next=l1nxt;
         l1=l1nxt;
         l2=l2nxt;
       }
    }
}