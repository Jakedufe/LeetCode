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


package leetcode.editor.cn;

import org.junit.Test;

import java.util.LinkedList;
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
            LinkedList<TreeNode> stack = new LinkedList<>();
            List<Integer> res = new LinkedList<>();
            if (root == null) {
                return res;
            }

            TreeNode cur = root;
            TreeNode last = null;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.peek();
                if (cur.right == null || cur.right == last) {
                    res.add(cur.val);
                    stack.pop();
                    last = cur;
                    cur = null;
                } else {
                    cur = cur.right;
                }
            }
            return res;
        }


//        public void postorderTraversal(TreeNode root, List<Integer> res) {
//            if (root == null) return;
//            postorderTraversal(root.left, res);
//            postorderTraversal(root.right, res);
//            res.add(root.val);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}