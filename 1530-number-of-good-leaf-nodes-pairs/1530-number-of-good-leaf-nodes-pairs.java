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
    private int result = 0;

    // Initiate depth first search
    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return result;
    }

    // Return array where each index i contains the number of leaf nodes
    // that are i distance away from the current node
    private int[] dfs(TreeNode node, int distance) {
        int[] counts = new int[distance + 1];
        // Empty node
        if (node == null) return counts;
        // Leaf found
        if (node.left == null && node.right == null) {
            counts[1] = 1;
            return counts;
        }
        
        // Split search, continue recursively
        int[] leftCounts = dfs(node.left, distance);
        int[] rightCounts = dfs(node.right, distance);
        
        // Update good leaf pairs
        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance - i; j++) {
                result += leftCounts[i] * rightCounts[j];
            }
        }

        // Update count array
        for (int i = 2; i <= distance; i++) {
            counts[i] = leftCounts[i - 1] + rightCounts[i - 1];
        }

        return counts;
    }
}