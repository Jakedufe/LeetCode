//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 764 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：二叉树的最近公共祖先
//2020-09-28 21:19:16
public class P236LowestCommonAncestorOfABinaryTree {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P236LowestCommonAncestorOfABinaryTree().new Solution();
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


        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left == null && right == null) return null; // 1.
            if (left == null) return right; // 3.
            if (right == null) return left; // 4.
            return root; // 2. if(left != null and right != null)
        }


//        boolean find = false;
//
//        /**
//         * 复杂思维
//         *
//         * @param root
//         * @param p
//         * @param q
//         * @return
//         */
//        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//            if (root == null) return null;
//            Deque<TreeNode> queueP = new LinkedList<>();
//            Deque<TreeNode> queueQ = new LinkedList<>();
//            dfs(root, p, queueP);
//            find = false;
//            dfs(root, q, queueQ);
//            TreeNode res = null;
//            while (!queueP.isEmpty() && !queueQ.isEmpty()) {
//                if (queueP.peek() == queueQ.peek()) {
//                    res = queueP.poll();
//                    queueQ.poll();
//                } else break;
//            }
//            return res;
//        }
//
//        private void dfs(TreeNode root, TreeNode target, Deque<TreeNode> queue) {
//            if (root == null) return;
//            if (find) return;
//            if (root == target) {
//                queue.offer(root);
//                find = true;
//                return;
//            }
//            queue.offer(root);
//            dfs(root.left, target, queue);
//            if (find) return;
//            dfs(root.right, target, queue);
//            if (find) return;
//            queue.pollLast();
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}