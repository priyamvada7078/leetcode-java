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

    int count = 0;

    // returns {sum, number of nodes}
    int[] helper(TreeNode root) {

        if (root == null) {
            return new int[]{0, 0};
        }

        // Traverse left subtree
        int[] left = helper(root.left);

        // Traverse right subtree
        int[] right = helper(root.right);

        // Current subtree sum
        int sum = root.val + left[0] + right[0];

        // Current subtree node count
        int n = 1 + left[1] + right[1];

        // Average
        int average = sum / n;

        // Check condition
        if (root.val == average) {
            count++;
        }

        return new int[]{sum, n};
    }

    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return count;
    }
}