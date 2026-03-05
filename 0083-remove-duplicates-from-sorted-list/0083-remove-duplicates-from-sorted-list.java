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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current=head;
        if(head==null){
            return null;
        }
        if(current.next==null){
            return current;
        }
        ListNode temp=head.next;
        while(temp!=null){
            if(current.val!=temp.val){
                current.next=temp;
                current=temp;
            }
            
             temp=temp.next;
            
        }
        current.next=null;
        return head;
    }
}