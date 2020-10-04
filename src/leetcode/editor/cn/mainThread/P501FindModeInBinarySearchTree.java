//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 163 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//Java：二叉搜索树中的众数
//2020-09-24 08:56:59
public class P501FindModeInBinarySearchTree {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P501FindModeInBinarySearchTree().new Solution();
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

        private int max = Integer.MIN_VALUE;
        private int last = 0;
        private int count = 0;
        private List<Integer> res = new ArrayList<>();

        public int[] findMode(TreeNode root) {
            if (root == null) return new int[0];
            last = 0;
            count = 0;
            TreeNode cur = root, pre;
            while (cur != null) {
                if (cur.left == null) {
                    update(cur);
                    cur = cur.right;
                    continue;
                }
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == cur) {
                    pre.right = null;
                    update(cur);
                    cur = cur.right;
                } else {
                    pre.right = cur;
                    cur = cur.left;
                }
            }

            int[] re = new int[res.size()];
            int index = 0;
            for (Integer integer : res) {
                re[index++] = integer;
            }
            return re;
        }

        private void update(TreeNode root) {
            if (root.val == last) {
                count++;
            } else {
                count = 1;
                last = root.val;
            }
            if (count == max) res.add(root.val);
            else if (count > max) {
                res.clear();
                max = count;
                res.add(root.val);
            }
        }

//        private int max = Integer.MIN_VALUE;
//        private int last = 0;
//        private int count = 0;
//        private List<Integer> res = new ArrayList<>();
//
//        public int[] findMode(TreeNode root) {
//            if (root == null) return new int[0];
//            last = 0;
//            count = 0;
//            process(root);
//            int[] re = new int[res.size()];
//            int index = 0;
//            for (Integer integer : res) {
//                re[index++] = integer;
//            }
//            return re;
//        }
//
//        private void process(TreeNode root) {
//            if (root == null) return;
//            process(root.left);
//            update(root);
//            process(root.right);
//        }
//
//        private void update(TreeNode root) {
//            if (root.val == last) {
//                count++;
//            } else {
//                count = 1;
//                last = root.val;
//            }
//            if (count == max) res.add(root.val);
//            else if (count > max) {
//                res.clear();
//                max = count;
//                res.add(root.val);
//            }
//        }


//        public int[] findMode(TreeNode root) {
//            if (root == null) return new int[0];
//            List<Integer> list = new ArrayList<>();
//            List<Integer> res = new ArrayList<>();
//            int max = Integer.MIN_VALUE;
//            int last;
//            int count = 0;
//            process(root, list);
//            last = list.get(0);
//            for (Integer integer : list) {
//                if (integer == last) {
//                    count++;
//                    max = Math.max(max, count);
//                } else {
//                    count = 1;
//                    last = integer;
//                }
//            }
//            count = 0;
//            last = list.get(0);
//            for (Integer integer : list) {
//                if (integer == last) {
//                    count++;
//                } else {
//                    last = integer;
//                    count = 1;
//                }
//                if (count == max) {
//                    res.add(integer);
//                }
//            }
//            int[] re = new int[res.size()];
//            int index = 0;
//            for (Integer integer : res) {
//                re[index++] = integer;
//            }
//            return re;
//        }
//
//        private void process(TreeNode root, List<Integer> list) {
//            if (root == null) return;
//            process(root.left, list);
//            list.add(root.val);
//            process(root.right, list);
//        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}