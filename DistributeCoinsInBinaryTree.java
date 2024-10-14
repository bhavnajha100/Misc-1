/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// Using DFS
    //TC : O(N)
    //SC : O(N)
class DistributeCoinsInBinaryTree {
    int moves = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode root) {
        // base
        if (root == null)
            return 0;
        // logic
        int extraCoins = root.val - 1;
        extraCoins += dfs(root.left);
        extraCoins += dfs(root.right);

        moves += Math.abs(extraCoins);
        return extraCoins;
    }
}