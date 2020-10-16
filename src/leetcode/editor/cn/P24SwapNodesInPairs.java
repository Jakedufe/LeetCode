//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 链表 
// 👍 715 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：两两交换链表中的节点
//2020-10-15 10:24:36
public class P24SwapNodesInPairs {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P24SwapNodesInPairs().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode p = head;
            ListNode q = p.next;
            head = q;
            while (q != null) {
                ListNode tmp = q.next;
                q.next = p;
                if (tmp != null) {
                    q = tmp.next;
                    if (q != null) {
                        p.next = q;
                    } else {
                        p.next = tmp;
                    }
                } else {
                    q = null;
                    p.next = null;
                }
                p = tmp;

            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}