//给定一个二叉树 
//
// struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数小于 6000 
// -100 <= node.val <= 100 
// 
//
// 
//
// 
// 
// Related Topics 树 深度优先搜索 
// 👍 240 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：填充每个节点的下一个右侧节点指针 II
//2020-09-28 12:05:37
public class P117PopulatingNextRightPointersInEachNodeIi {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P117PopulatingNextRightPointersInEachNodeIi().new Solution();
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        Node head;
        Node last;

        /**
         * O(1) 空间复杂度
         *
         * @param root
         * @return
         */
        public Node connect(Node root) {
            if (root == null) return null;
            Node leftMost = root;
            while (leftMost != null) {
                last = null;
                head = null;
                for (Node p = leftMost; p != null; p = p.next) {
                    if (p.left != null) {
                        handle(p.left);
                    }
                    if (p.right != null) {
                        handle(p.right);
                    }
                }
                leftMost = head;
            }
            return root;
        }

        private void handle(Node p) {
            if (last != null) {
                last.next = p;
            }
            if (head == null) {
                head = p;
            }
            last = p;
        }


//        /**
//         * BFS 解法
//         *
//         * @param root
//         * @return
//         */
//        public Node connect(Node root) {
//            Deque<Node> queue = new LinkedList<>();
//            if (root == null) return null;
//            queue.offer(root);
//            while (!queue.isEmpty()) {
//                int size = queue.size();
//                for (int i = 0; i < size; i++) {
//                    Node poll = queue.poll();
//                    if (poll.left != null) queue.offer(poll.left);
//                    if (poll.right != null) queue.offer(poll.right);
//                    if (i < size - 1) poll.next = queue.peek();
//                }
//            }
//            return root;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}