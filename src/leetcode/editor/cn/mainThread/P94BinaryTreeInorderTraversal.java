//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 725 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树的中序遍历
//2020-09-27 16:41:21
public class P94BinaryTreeInorderTraversal {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

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
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorderTraversal(root, res);
            return res;
        }

        /**
         * Morris解法
         *
         * @param root
         * @param res
         */
        private void inorderTraversal(TreeNode root, List<Integer> res) {
            TreeNode cur1 = root;
            TreeNode cur2;
            while (cur1 != null) {
                cur2 = cur1.left;
                if (cur2 != null) {
                    while (cur2.right != null && cur2.right != cur1) {
                        cur2 = cur2.right;
                    }
                    if (cur2.right == null) {
                        cur2.right = cur1;
                        cur1 = cur1.left;
                        continue;
                    } else {
                        cur2.right = null;
                    }
                }
                res.add(cur1.val);
                cur1 = cur1.right;
            }
        }

        //    /**
//     * 迭代解法
//     * @param root
//     * @param res
//     */
//    private void inorderTraversal(TreeNode root, List<Integer> res) {
//            Deque<TreeNode> stack = new LinkedList<>();
//            TreeNode p = root;
//            while (p != null || !stack.isEmpty()) {
//                while (p != null) {
//                    stack.push(p);
//                    p = p.left;
//                }
//                p = stack.pop();
//                res.add(p.val);
//                p = p.right;
//            }
//    }
//
//        /**
//         * 递归解法
//         * @param root
//         * @param res
//         */
//        public void inorderTraversal(TreeNode root, List<Integer> res) {
//            if (root == null) return;
//            inorderTraversal(root.left, res);
//            res.add(root.val);
//            inorderTraversal(root.right, res);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}