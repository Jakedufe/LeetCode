//给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。 
//
// 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 1->3->5->2->4->NULL
// 
//
// 示例 2: 
//
// 输入: 2->1->3->5->6->4->7->NULL 
//输出: 2->3->6->7->1->5->4->NULL 
//
// 说明: 
//
// 
// 应当保持奇数节点和偶数节点的相对顺序。 
// 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。 
// 
// Related Topics 链表 
// 👍 245 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：奇偶链表
//2020-09-25 12:11:13
public class P328OddEvenLinkedList {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P328OddEvenLinkedList().new Solution();
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
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode p = head;
            ListNode q = head.next;
            ListNode h2 = q;
            while (q.next != null && p.next != null) {
                p.next = q.next;
                p = p.next;
                if (p.next != null) {
                    q.next = p.next;
                    q = q.next;
                }
            }
            p.next = h2;
            q.next = null;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}