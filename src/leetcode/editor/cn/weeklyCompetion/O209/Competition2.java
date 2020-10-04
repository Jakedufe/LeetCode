package leetcode.editor.cn.weeklyCompetion.O209;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;


//Java：周赛
//2020-09-19 15:09:18
public class Competition2 {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new Competition2().new Solution();


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
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
        public boolean isEvenOddTree(TreeNode root) {
            Deque<TreeNode> queue = new LinkedList<>();
            if (root.val % 2 == 0) return false;
            queue.offerLast(root);
            int level = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (level % 2 != 0) {
                        if (poll.val % 2 != 0) return false;
                        if (i < size - 1 && poll.val <= queue.peek().val) return false;
                    } else {
                        if (poll.val % 2 == 0) return false;
                        if (i < size - 1 && poll.val >= queue.peek().val) return false;
                    }
                    if (poll.left != null) queue.offerLast(poll.left);
                    if (poll.right != null) queue.offerLast(poll.right);
                }
                level++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}