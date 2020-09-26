//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 348 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Java：路径总和 II
//2020-09-26 22:36:55
public class P113PathSumIi {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P113PathSumIi().new Solution();
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
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> lists = new ArrayList<>();
            Deque<Integer> stack = new LinkedList<>();
            pathSum(root, 0, sum, lists, stack);
            return lists;
        }

        public void pathSum(TreeNode root, int count, int sum, List<List<Integer>> lists, Deque<Integer> stack) {
            if (root == null) return;
            int val = root.val;
            if (root.left == null && root.right == null && count + val == sum) {
                stack.push(val);
                LinkedList<Integer> list = new LinkedList<>();
                int size = stack.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = stack.pollFirst();
                    list.addFirst(poll);
                    stack.offerLast(poll);
                }
                stack.pop();
                lists.add(list);
                return;
            }
            stack.push(val);
            pathSum(root.left, count + val, sum, lists, stack);
            pathSum(root.right, count + val, sum, lists, stack);
            stack.pop();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}