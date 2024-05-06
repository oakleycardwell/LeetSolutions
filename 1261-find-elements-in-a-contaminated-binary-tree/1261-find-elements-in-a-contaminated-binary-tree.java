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
public class FindElements {
    // Store the recovered node values
    private HashSet<Integer> recoveredValues; 

    public FindElements(TreeNode root) {
        recoveredValues = new HashSet<>();
        // Start recovery with the root node value set to 0
        recover(root, 0); 
    }

    // Helper method to recover the tree
    private void recover(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        
        // Set the node value and add to set
        node.val = val; 
        recoveredValues.add(val); 

        // Recover the left child with the formula 2 * val + 1
        if (node.left != null) {
            recover(node.left, 2 * val + 1);
        }
        // Recover the right child with the formula 2 * val + 2
        if (node.right != null) {
            recover(node.right, 2 * val + 2);
        }
    }

    // Method to check if a target value exists in the recovered tree
    public boolean find(int target) {
        return recoveredValues.contains(target); 
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */