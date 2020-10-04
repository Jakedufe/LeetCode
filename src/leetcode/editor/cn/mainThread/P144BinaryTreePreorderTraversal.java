//给定一个二叉树，返回它的 前序 遍历。 
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
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 370 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树的前序遍历
//2020-09-26 12:06:57
public class P144BinaryTreePreorderTraversal {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            preorderTraversal(root, res);
            return res;
        }

        /**
         * Morris解法
         *
         * @param root
         * @param res
         */
        public void preorderTraversal(TreeNode root, List<Integer> res) {
            if (root == null) return;
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
                        res.add(cur1.val);
                        cur1 = cur1.left;
                        continue;
                    } else {
                        cur2.right = null;
                    }
                } else {
                    res.add(cur1.val);
                }
                cur1 = cur1.right;
            }
        }

//        /**
//         * 迭代解法
//         * @param root
//         * @param res
//         */
//        private void preorderTraversal(TreeNode root, List<Integer> res) {
//            Deque<TreeNode> stack = new LinkedList<>();
//            TreeNode p = root;
//            while (p != null || !stack.isEmpty()) {
//                while (p != null) {
//                    res.add(p.val);
//                    stack.push(p);
//                    p = p.left;
//                }
//                p = stack.pop();
//                p = p.right;
//            }
//        }
//
//        /**
//         * 递归解法
//         * @param root
//         * @param res
//         */
//        public void preorderTraversal(TreeNode root, List<Integer> res) {
//            if (root == null) return;
//            res.add(root.val);
//            preorderTraversal(root.left, res);
//            preorderTraversal(root.right, res);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}