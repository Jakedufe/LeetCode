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


package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
            TreeNode p = root;
            Deque<TreeNode> stack = new LinkedList<>();
            while (p != null) {
                res.add(p.val);
                if (p.left != null) {
                    stack.push(p);
                    p = p.left;
                } else {
                    p = p.right;
                    while (p == null && !stack.isEmpty()) {
                        p = stack.pop().right;
                    }
                }
            }
            return res;
        }
//
//        public void preorderTraversal(TreeNode root, List<Integer> res) {
//            if (root == null) return;
//            res.add(root.val);
//            preorderTraversal(root.left, res);
//            preorderTraversal(root.right, res);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}