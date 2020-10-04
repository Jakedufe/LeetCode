//给定一个二叉树，返回它的 后序 遍历。 
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
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 401 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树的后序遍历
//2020-09-26 12:10:12
public class P145BinaryTreePostorderTraversal {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            postorderTraversal(root, res);
            return res;
        }

        /**
         * Morris解法
         * @param root
         * @param res
         */
        public void postorderTraversal(TreeNode root, List<Integer> res) {
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
                        reverseListAdd(cur1.left, res);
                    }
                }
                cur1 = cur1.right;
            }
            reverseListAdd(root, res);
        }

        private void reverseListAdd(TreeNode root, List<Integer> res) {
            TreeNode firstNode = reverseList(root);
            TreeNode p = firstNode;
            while (p != null) {
                res.add(p.val);
                p = p.right;
            }
            reverseList(firstNode);
        }

        private TreeNode reverseList(TreeNode root) {
            TreeNode p = null;
            TreeNode q = root;
            while (q != null) {
                TreeNode tmp = q.right;
                q.right = p;
                p = q;
                q = tmp;
            }
            return p;
        }

//        /**
//         * 迭代解法
//         * @param root
//         * @param res
//         */
//        private void postorderTraversal(TreeNode root, List<Integer> res) {
//            LinkedList<TreeNode> stack = new LinkedList<>();
//            TreeNode p = root;
//            TreeNode last = null;
//            while (p != null || !stack.isEmpty()) {
//                while (p != null) {
//                    stack.push(p);
//                    p = p.left;
//                }
//                p = stack.peek();
//                if (p.right == null || p.right == last) {
//                    res.add(p.val);
//                    stack.pop();
//                    last = p;
//                    p = null;
//                } else {
//                    p = p.right;
//                }
//            }
//        }
//
//        /**
//         * 递归解法
//         * @param root
//         * @param res
//         */
//        public void postorderTraversal(TreeNode root, List<Integer> res) {
//            if (root == null) return;
//            postorderTraversal(root.left, res);
//            postorderTraversal(root.right, res);
//            res.add(root.val);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}