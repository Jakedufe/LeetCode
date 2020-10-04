//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索 
// 👍 435 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

//Java：路径总和
//2020-09-28 16:16:20
public class P112PathSum {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P112PathSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        boolean res = false;

        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) return false;
            hasPathSum(root, sum, 0);
            return res;
        }

        private void hasPathSum(TreeNode root, int sum, int count) {
            if (res) return;
            if (root.left == null && root.right == null) {
                if (sum == count + root.val)
                    res = true;
                return;
            }
            if (root.left != null)
                hasPathSum(root.left, sum, count + root.val);
            if (root.right != null)
                hasPathSum(root.right, sum, count + root.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}