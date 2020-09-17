//给定一个二叉树，我们在树的节点上安装摄像头。 
//
// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。 
//
// 计算监控树的所有节点所需的最小摄像头数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
// 
//
// 
//提示： 
//
// 
// 给定树的节点数的范围是 [1, 1000]。 
// 每个节点的值都是 0。 
// 
// Related Topics 树 深度优先搜索 动态规划 
// 👍 89 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：监控二叉树
//2020-09-15 11:25:41
public class P968BinaryTreeCameras {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P968BinaryTreeCameras().new Solution();
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


        public int minCameraCover(TreeNode root) {
            int[] a;
            a = process(root);
            return Math.min(a[1], a[2]);
        }

        private int[] process(TreeNode node) {
            if (node == null) {
                return new int[]{0, 0, 99999};
            }
            int[] left = process(node.left);
            int[] right = process(node.right);
            int[] par = new int[3];
            int mL = Math.min(left[1], left[2]);
            int mR = Math.min(right[1], right[2]);

            par[0] = mL + mR;
            par[1] = Math.min(mL + right[2], mR + left[2]);
            par[2] = 1 + Math.min(mL, left[0]) + Math.min(mR, right[0]);
            return par;
        }
//    class Solution {
//        int ans = 0;
//        Set<TreeNode> covered = new HashSet<>();
//
//        public int minCameraCover(TreeNode root) {
//            TreeNode par = null;
//            covered.add(null);
//            dfs(root, par);
//            return ans;
//        }
//
//        private void dfs(TreeNode node, TreeNode par) {
//            if (node != null) {
//                dfs(node.left, node);
//                dfs(node.right, node);
//
//                if (!covered.contains(node.left)
//                        || !covered.contains(node.right)
//                        || !covered.contains(node) && par == null) {
//                    ans++;
//                    covered.add(node);
//                    covered.add(node.left);
//                    covered.add(node.right);
//                    covered.add(par);
//                }
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}