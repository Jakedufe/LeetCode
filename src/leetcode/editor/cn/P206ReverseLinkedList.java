//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1238 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：反转链表
//2020-09-25 11:49:11
public class P206ReverseLinkedList {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P206ReverseLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode p = head;
            ListNode tmp;
            ListNode q = head.next;
            p.next = null;
            while (q != null) {
                tmp = q;
                q = q.next;
                tmp.next = p;
                p = tmp;
            }
            return p;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}