//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 637 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Java：二叉树的层序遍历
//2020-09-19 12:09:39
public class P102BinaryTreeLevelOrderTraversal {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();

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

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            Deque<TreeNode> queue = new LinkedList<>();
            if (root == null) return lists;
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    list.add(poll.val);
                    if (poll.left != null) queue.offer(poll.left);
                    if (poll.right != null) queue.offer(poll.right);
                }
                lists.add(list);
            }
            return lists;
        }
    }

//    class Solution2 {
//        class NullTreeNode extends TreeNode {
//            int level = 0;
//
//            NullTreeNode(int x) {
//                super(x);
//            }
//        }
//
//        public List<List<Integer>> levelOrder(TreeNode root) {
//
//            List<List<Integer>> lists = new ArrayList<>();
//            if (root == null) return lists;
//
//            Deque<TreeNode> queue = new LinkedList<>();
//            Deque<TreeNode> tmpResult = new LinkedList<>();
//            NullTreeNode level = new NullTreeNode(0);
//            boolean flag = false;
//            queue.offer(root);
//            queue.offer(level);
//
//            while (!queue.isEmpty()) {
//                TreeNode cur = queue.poll();
//                if (cur instanceof NullTreeNode) {
//                    if (!flag) break;
//                    queue.offer(cur);
//                    flag = false;
//                    List<Integer> list = new ArrayList<>();
//                    while (!tmpResult.isEmpty()) {
//                        list.add(tmpResult.poll().val);
//                    }
//                    lists.add(list);
//                    continue;
//                }
//                flag = true;
//                tmpResult.offer(cur);
//                if (cur.left != null) queue.offer(cur.left);
//                if (cur.right != null) queue.offer(cur.right);
//            }
//
//            return lists;
//        }
//    }

    //leetcode submit region end(Prohibit modification and deletion)

}