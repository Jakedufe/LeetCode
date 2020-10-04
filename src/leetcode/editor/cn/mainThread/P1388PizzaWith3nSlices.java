//给你一个披萨，它由 3n 块不同大小的部分组成，现在你和你的朋友们需要按照如下规则来分披萨： 
//
// 
// 你挑选 任意 一块披萨。 
// Alice 将会挑选你所选择的披萨逆时针方向的下一块披萨。 
// Bob 将会挑选你所选择的披萨顺时针方向的下一块披萨。 
// 重复上述过程直到没有披萨剩下。 
// 
//
// 每一块披萨的大小按顺时针方向由循环数组 slices 表示。 
//
// 请你返回你可以获得的披萨大小总和的最大值。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：slices = [1,2,3,4,5,6]
//输出：10
//解释：选择大小为 4 的披萨，Alice 和 Bob 分别挑选大小为 3 和 5 的披萨。然后你选择大小为 6 的披萨，Alice 和 Bob 分别挑选大小
//为 2 和 1 的披萨。你获得的披萨总大小为 4 + 6 = 10 。
// 
//
// 示例 2： 
//
// 
//
// 输入：slices = [8,9,8,6,1,1]
//输出：16
//解释：两轮都选大小为 8 的披萨。如果你选择大小为 9 的披萨，你的朋友们就会选择大小为 8 的披萨，这种情况下你的总和不是最大的。
// 
//
// 示例 3： 
//
// 输入：slices = [4,1,2,5,8,3,1,9,7]
//输出：21
// 
//
// 示例 4： 
//
// 输入：slices = [3,1,2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= slices.length <= 500 
// slices.length % 3 == 0 
// 1 <= slices[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 56 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

import java.util.PriorityQueue;

//Java：3n 块披萨
//2020-10-03 12:10:39
public class P1388PizzaWith3nSlices {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P1388PizzaWith3nSlices().new Solution();
        System.out.println(solution.maxSizeSlices(new int[]{9, 3, 6, 4, 2, 1, 1, 6, 3, 6, 10, 9, 4, 10, 10, 10, 10, 10, 7, 10, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class ListNode {
            int value;
            ListNode pre, next;
            boolean isDel;

            ListNode() {
            }

            ListNode(int value, ListNode pre, ListNode next) {
                this.value = value;
                this.pre = pre;
                this.next = next;
            }
        }

        /**
         * 贪心算法:将原问题转化为规模为 N-2 的子问题
         *
         * @param slices
         * @return
         */
        public int maxSizeSlices(int[] slices) {
            int n = slices.length;
            int k = n / 3;
            ListNode head = new ListNode();
            createList(head, slices);
            PriorityQueue<Solution.ListNode> queue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
            ListNode p = head.next;
            queue.offer(p);
            while (p.next != head.next) {
                p = p.next;
                queue.offer(p);
            }
            int cnt = 0;
            int ans = 0;
            while (cnt < k) {
                ListNode poll = queue.poll();
                if (poll.isDel) continue;
                cnt++;
                ans += poll.value;
                poll.value = poll.next.value + poll.pre.value - poll.value;
                poll.pre.isDel = true;
                poll.next.isDel = true;
                poll.next = poll.next.next;
                poll.next.pre = poll;
                poll.pre = poll.pre.pre;
                poll.pre.next = poll;
                queue.offer(poll);
            }
            return ans;
        }

        private void createList(ListNode head, int[] arr) {
            ListNode p = head;
            for (int i = 0; i < arr.length; i++) {
                p.next = new ListNode(arr[i], p, null);
                p = p.next;
            }
            p.next = head.next;
            head.next.pre = p;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//        /**
//         * 环形二维打家劫舍
//         * @param slices
//         * @return
//         */
//        public int maxSizeSlices(int[] slices) {
//            int n = slices.length;
//            int[] cp1 = new int[n - 1];
//            int[] cp2 = new int[n - 1];
//            System.arraycopy(slices, 0, cp1, 0, n - 1);
//            System.arraycopy(slices, 1, cp2, 0, n - 1);
//            return Math.max(cal(cp1), cal(cp2));
//        }
//
//        private int cal(int[] arr) {
//            int n = arr.length;
//            int choose = (n + 1) / 3;
//            int[][] dp = new int[n + 1][choose + 1];
//            for (int i = 1; i <= n; i++) {
//                for (int j = 1; j <= choose; j++) {
//                    dp[i][j] = Math.max(dp[i - 1][j], (i - 2 >= 0 ? dp[i - 2][j - 1] : 0) + arr[i - 1]);
//                }
//            }
//            return dp[n][choose];
//        }