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

import java.util.Deque;
import java.util.LinkedList;

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
            if (postorder == null || postorder.length == 0) return null;
            TreeNode root = new TreeNode(postorder[postorder.length - 1]);
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            int index = inorder.length - 1;
            for (int i = postorder.length - 2; i >= 0; i--) {
                int postVal = postorder[i];
                TreeNode node = stack.peek();
                if (node.val != inorder[index]) {
                    node.right = new TreeNode(postVal);
                    stack.push(node.right);
                } else {
                    while (!stack.isEmpty() && stack.peek().val == inorder[index]) {
                        node = stack.pop();
                        index--;
                    }
                    node.left = new TreeNode(postVal);
                    stack.push(node.left);
                }
            }
            return root;
        }
//        int postIndex;
//
//        public TreeNode buildTree(int[] inorder, int[] postorder) {
//            Map<Integer, Integer> hashMap = new HashMap<>();
//            for (int i = 0; i < inorder.length; i++) {
//                hashMap.put(inorder[i], i);
//            }
//            postIndex = postorder.length - 1;
//            return buildTree(inorder, 0, inorder.length - 1, postorder, hashMap);
//        }
//
//        /**
//         * 递归解法
//         *
//         * @param inOrder
//         * @param inLeft
//         * @param inRight
//         * @param postOrder
//         * @param hashMap
//         * @return
//         */
//        public TreeNode buildTree(int[] inOrder, int inLeft, int inRight, int[] postOrder, Map<Integer, Integer> hashMap) {
//            if (inLeft > inRight) return null;
//            Integer pos = hashMap.get(postOrder[postIndex]);
//            TreeNode node = new TreeNode(inOrder[pos]);
//            postIndex--;
//            node.right = buildTree(inOrder, pos + 1, inRight, postOrder, hashMap);
//            node.left = buildTree(inOrder, inLeft, pos - 1, postOrder, hashMap);
//            return node;
//        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
}
