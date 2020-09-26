//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 646 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//Java：回文链表
//2020-09-25 14:07:32
public class P234PalindromeLinkedList {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P234PalindromeLinkedList().new Solution();
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
        public boolean isPalindrome(ListNode head) {
            if (head == null) return true;
            ListNode p = head;
            List<Integer> list = new ArrayList<>();
            while (p != null) {
                list.add(p.val);
                p = p.next;
            }
            for (int i = 0; i < list.size() / 2; i++) {
                if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}