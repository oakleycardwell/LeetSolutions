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
        // Add values to ArrayList for processing
        ArrayList<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        
        // Return list
        int[] answer = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        
        
        for (int i = 0; i < list.size(); i++) {
            // Add values to stack while current > next
            // Else empty stack to fill array values
            while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
                answer[stack.pop()] = list.get(i);
            }
            // Current > next
            stack.push(i);
        }
        
        return answer;
    }
}
