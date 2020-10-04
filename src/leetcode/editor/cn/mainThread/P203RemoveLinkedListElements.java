//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 446 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

//Java：移除链表元素
//2020-09-25 12:03:40
public class P203RemoveLinkedListElements {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P203RemoveLinkedListElements().new Solution();
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
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) return null;
            while (head != null && head.val == val) head = head.next;
            ListNode p = head;
            while (p != null && p.next != null) {
                if (p.next.val == val) {
                    p.next = p.next.next;
                } else
                    p = p.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}