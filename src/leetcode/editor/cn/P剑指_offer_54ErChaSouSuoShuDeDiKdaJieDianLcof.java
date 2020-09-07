//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 60 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：二叉搜索树的第k大节点
public class P剑指_offer_54ErChaSouSuoShuDeDiKdaJieDianLcof {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P剑指_offer_54ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
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
        int re = 0;
        int K;

        public int kthLargest(TreeNode root, int k) {
            K = k;
            process(root);
            return re;
        }

        private void process(TreeNode root) {
            if (K == 0) return;
            if (root.right != null)
                process(root.right);
            K--;
            if (K == 0) re = root.val;
            if (K == 0) return;
            if (root.left != null)
                process(root.left);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}