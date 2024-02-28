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
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        
        int[] answer = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
                answer[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        
        return answer;
    }
}

// while node.next != null
// if this.node < node.next
// 