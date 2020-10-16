//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 
// 👍 169 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：二叉搜索树的最小绝对差
//2020-10-12 14:46:01
public class P530MinimumAbsoluteDifferenceInBst {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P530MinimumAbsoluteDifferenceInBst().new Solution();
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
        public int getMinimumDifference(TreeNode root) {
            if (root == null) return 0;
            List<Integer> list = new ArrayList<>();
            process(root, list);
            Integer[] integers = list.toArray(new Integer[0]);
            Arrays.sort(integers);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < integers.length - 1; i++) {
                min = Math.min(min, integers[i + 1] - integers[i]);
            }
            return min;
        }

        private void process(TreeNode par, List<Integer> list) {
            if (par == null) return;
            list.add(par.val);
            process(par.left, list);
            process(par.right, list);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}