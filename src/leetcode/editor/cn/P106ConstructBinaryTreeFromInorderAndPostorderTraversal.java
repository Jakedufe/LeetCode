//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 307 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：从中序与后序遍历序列构造二叉树
//2020-09-25 08:47:10
public class P106ConstructBinaryTreeFromInorderAndPostorderTraversal {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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


        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return buildTree(inorder, 0, postorder, 0, inorder.length);
        }

        public TreeNode buildTree(int[] inorder, int startA, int[] postorder, int startB, int len) {
            if (startA >= inorder.length || startB >= postorder.length
                    || startB + len - 1 >= postorder.length || len == 0)
                return null;
            TreeNode node = new TreeNode(postorder[startB + len - 1]);
            for (int i = 0; i < len; i++) {
                if (inorder[startA + i] == postorder[startB + len - 1]) {
                    node.left = buildTree(inorder, startA, postorder, startB, i);
                    node.right = buildTree(inorder, startA + i + 1, postorder, startB + i, len - i - 1);
                }
            }
            return node;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
}
