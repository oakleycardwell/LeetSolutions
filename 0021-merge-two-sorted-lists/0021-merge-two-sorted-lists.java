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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode retList = new ListNode();
        ListNode head = retList;
        
        while(list1 != null || list2 != null){
            if (list1 == null){
                retList.next = list2;
                retList = retList.next;
                list2 = list2.next;
            }
            else if (list2 == null){
                retList.next = list1;
                retList = retList.next;
                list1 = list1.next;
            }
            else if (list1.val <= list2.val){
                retList.next = list1;
                retList = retList.next;
                list1 = list1.next;
            }
            else {
                retList.next = list2;
                retList = retList.next;
                list2 = list2.next;
            }
        }
        
        return head.next;
        
    }
}