//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1049 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

//Java：对称二叉树
//2020-09-28 15:29:03
public class P101SymmetricTree {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P101SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return isSymmetric(root.left, root.right);
        }

        /**
         * 递归解法
         *
         * @param left
         * @param right
         * @return
         */
        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null) return false;
            if (right == null) return false;
            return left.val == right.val
                    && isSymmetric(left.right, right.left)
                    && isSymmetric(left.left, right.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}