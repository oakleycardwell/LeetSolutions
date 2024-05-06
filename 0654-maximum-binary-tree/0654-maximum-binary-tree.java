/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // Starts building method
        return build(nums, 0, nums.length);
    }
    
     private TreeNode build(int[] nums, int start, int end) {
        // If the current subarray is empty, return null
        if (start == end) {
            return null;
        }
        
        // Find the index of the maximum element in the current subarray
        int maxIndex = start;
        for (int i = start + 1; i < end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        
        // Create a new TreeNode with the maximum element found
        TreeNode root = new TreeNode(nums[maxIndex]);
        // Recursively build the left subtree from elements before max
        root.left = build(nums, start, maxIndex);
        // Recursively build the right subtree from elements after max
        root.right = build(nums, maxIndex + 1, end);
        
        // Return root of new tree
        return root;
    }
}