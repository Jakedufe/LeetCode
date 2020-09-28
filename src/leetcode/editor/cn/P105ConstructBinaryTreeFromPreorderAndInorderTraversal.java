//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 695 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

//Java：从前序与中序遍历序列构造二叉树
//2020-09-28 17:08:25
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] a = new int[]{3, 9, 20, 15, 7};
        int[] b = new int[]{9, 3, 15, 20, 7};
        System.out.println(solution.buildTree(a, b));
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
        /**
         * 比较精妙的迭代法，关键在于前序遍历中相邻节点的关系
         *
         * @param preorder
         * @param inorder
         * @return
         */
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0) return null;
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode root = new TreeNode(preorder[0]);
            stack.push(root);
            int index = 0;
            for (int i = 1; i < preorder.length; i++) {
                int preVal = preorder[i];
                TreeNode node = stack.peek();
                if (inorder[index] != node.val) {
                    node.left = new TreeNode(preVal);
                    stack.push(node.left);
                } else {
                    while (!stack.isEmpty() && inorder[index] == stack.peek().val) {
                        node = stack.pop();
                        index++;
                    }
                    node.right = new TreeNode(preVal);
                    stack.push(node.right);
                }
            }
            return root;
        }


//        int posIndex;
//
//        public TreeNode buildTree(int[] preorder, int[] inorder) {
//            posIndex = 0;
//            Map<Integer, Integer> hashMap = new HashMap<>();
//            for (int i = 0; i < inorder.length; i++) {
//                hashMap.put(inorder[i], i);
//            }
//            return buildTree(preorder, inorder, 0, inorder.length - 1, hashMap);
//        }
//
//        /**
//         * 递归解法，参数更清晰
//         * @param preOrder
//         * @param inOrder
//         * @param inLeft
//         * @param inRight
//         * @param hashMap
//         * @return
//         */
//        private TreeNode buildTree(int[] preOrder, int[] inOrder, int inLeft, int inRight, Map<Integer, Integer> hashMap) {
//            if (inLeft > inRight) return null;
//            Integer pos = hashMap.get(preOrder[posIndex]);
//            TreeNode node = new TreeNode(inOrder[pos]);
//            posIndex++;
//            node.left = buildTree(preOrder, inOrder, inLeft, pos - 1, hashMap);
//            node.right = buildTree(preOrder, inOrder, pos + 1, inRight, hashMap);
//            return node;
//        }

//        /**
//         * 递归解法
//         *
//         * @param preorder
//         * @param preLeft
//         * @param preRight
//         * @param inLeft
//         * @param hashMap
//         * @return
//         */
//        private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int inLeft, Map<Integer, Integer> hashMap) {
//            if (preLeft > preRight) return null;
//            Integer pos = hashMap.get(preorder[preLeft]);
//            TreeNode node = new TreeNode(preorder[preLeft]);
//            int len = pos - inLeft;
//            node.left = buildTree(preorder, preLeft + 1, preLeft + len, inLeft, hashMap);
//            node.right = buildTree(preorder, preLeft + len + 1, preRight, pos + 1, hashMap);
//            return node;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}