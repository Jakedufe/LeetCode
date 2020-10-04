//给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。 
//
// 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 
//C[i+A.length] = C[i]） 
//
// 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, 
//k2 <= j 其中 k1 % A.length = k2 % A.length） 
//
// 
//
// 示例 1： 
//
// 输入：[1,-2,3,-2]
//输出：3
//解释：从子数组 [3] 得到最大和 3
// 
//
// 示例 2： 
//
// 输入：[5,-3,5]
//输出：10
//解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
// 
//
// 示例 3： 
//
// 输入：[3,-1,2,-1]
//输出：4
//解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
// 
//
// 示例 4： 
//
// 输入：[3,-2,2,-3]
//输出：3
//解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
// 
//
// 示例 5： 
//
// 输入：[-2,-3,-1]
//输出：-1
//解释：从子数组 [-1] 得到最大和 -1
// 
//
// 
//
// 提示： 
//
// 
// -30000 <= A[i] <= 30000 
// 1 <= A.length <= 30000 
// 
// Related Topics 数组 
// 👍 111 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

//Java：环形子数组的最大和
//2020-10-01 20:55:27
public class P918MaximumSumCircularSubarray {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P918MaximumSumCircularSubarray().new Solution();
        System.out.println(solution.maxSubarraySumCircular(new int[]{-2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 求中间单区间最小值
         *
         * @param A
         * @return
         */
        public int maxSubarraySumCircular(int[] A) {
            int S = 0;  // S = sum(A)
            for (int x : A)
                S += x;
            int cur1 = A[0];
            int ans1 = A[0];
            for (int i = 1; i < A.length; i++) {
                cur1 = A[i] + Math.max(cur1, 0);
                ans1 = Math.max(ans1, cur1);
            }
            if (A.length == 1) return ans1;
            int cur2 = A[0];
            int ans2 = A[0];
            for (int i = 1; i < A.length - 1; i++) {
                cur2 = A[i] + Math.min(cur2, 0);
                ans2 = Math.min(ans2, cur2);
            }
            int cur3 = A[1];
            int ans3 = A[1];
            for (int i = 2; i < A.length; i++) {
                cur3 = A[i] + Math.min(cur3, 0);
                ans3 = Math.min(ans3, cur3);
            }
            return Math.max(ans1, Math.max(S - ans2, S - ans3));
        }

//        /**
//         * 正序数组和减去相反数数组的最大和
//         *
//         * @param A
//         * @return
//         */
//        public int maxSubarraySumCircular(int[] A) {
//            int S = 0;  // S = sum(A)
//            for (int x : A)
//                S += x;
//
//            int ans1 = kadane(A, 0, A.length - 1, 1);
//            int ans2 = S + kadane(A, 1, A.length - 1, -1);
//            int ans3 = S + kadane(A, 0, A.length - 2, -1);
//            return Math.max(ans1, Math.max(ans2, ans3));
//        }
//
//        public int kadane(int[] A, int i, int j, int sign) {
//            // The maximum non-empty subarray for array
//            // [sign * A[i], sign * A[i+1], ..., sign * A[j]]
//            int ans = Integer.MIN_VALUE / 2;
//            int cur = Integer.MIN_VALUE / 2;
//            for (int k = i; k <= j; ++k) {
//                cur = sign * A[k] + Math.max(cur, 0);
//                ans = Math.max(ans, cur);
//            }
//            return ans;
//        }


//        /**
//         * 前缀和做差
//         *
//         * @param A
//         * @return
//         */
//        public int maxSubarraySumCircular(int[] A) {
//            int n = A.length;
//            if (n == 0) return 0;
//            int[] arr = new int[2 * n + 1];
//            for (int i = 0; i < 2 * n; i++) {
//                arr[i + 1] = arr[i] + A[i % n];
//            }
//            int ans = A[0];
//            Deque<Integer> queue = new ArrayDeque<>();
//            queue.offer(0);
//            for (int i = 1; i <= 2 * n; i++) {
//                if (i - n > queue.peekFirst()) {
//                    queue.pollFirst();
//                }
//                ans = Math.max(ans, arr[i] - arr[queue.peekFirst()]);
//                while (!queue.isEmpty() && arr[queue.peekLast()] >= arr[i]) {
//                    queue.pollLast();
//                }
//                queue.offerLast(i);
//            }
//            return ans;
//        }

//        /**
//         * 两区间数组最大和
//         *
//         * @param A
//         * @return
//         */
//        public int maxSubarraySumCircular(int[] A) {
//            int n = A.length;
//            if (n == 0) return 0;
//            int count = A[0];
//            int ans = A[0];
//            for (int i = 1; i < n; i++) {
//                count = A[i] + Math.max(0, count);
//                ans = Math.max(ans, count);
//            }
//            int[] right = new int[n];
//            int[] rightMax = new int[n];
//            rightMax[n - 1] = right[n - 1] = A[n - 1];
//            for (int i = n - 2; i >= 2; i--) {
//                right[i] = right[i + 1] + A[i];
//            }
//            for (int i = n - 2; i >= 2; i--) {
//                rightMax[i] = Math.max(rightMax[i+1], right[i]);
//            }
//            count = 0;
//            for (int i = 0; i < n - 2; i++) {
//                count += A[i];
//                ans = Math.max(ans, count + rightMax[i + 2]);
//            }
//            return ans;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}