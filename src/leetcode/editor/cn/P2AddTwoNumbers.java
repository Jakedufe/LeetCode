//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5014 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：两数相加
//2020-10-04 13:07:20
public class P2AddTwoNumbers {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P2AddTwoNumbers().new Solution();
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) return l1;
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode p = l1.next;
            ListNode pre = l1;
            ListNode q = l2.next;
            int val = l1.val + l2.val;
            l1.val = val % 10;
            int ten = val / 10;
            while (p != null && q != null) {
                int num = p.val + q.val + ten;
                p.val = num % 10;
                ten = num / 10;
                p = p.next;
                q = q.next;
                pre = pre.next;
            }
            if (q != null) {
                pre.next = q;
            }
            p = pre.next;
            while (p != null) {
                int num = p.val + ten;
                p.val = num % 10;
                ten = num / 10;
                p = p.next;
                pre = pre.next;
            }
            if (ten != 0) {
                pre.next = new ListNode(ten, null);
            }
            return l1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}