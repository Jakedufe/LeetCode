//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划 
// 👍 914 👎 0
//map<数值，位置>
//2 3 5 7 9 10 18 101
//2 4 3 5 1 0 7   6
//4 3 3 2 2 2 1   1

package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

//Java：最长上升子序列
public class P300LongestIncreasingSubsequence {

    @Test
    public void testResult() {
        Solution solution = new P300LongestIncreasingSubsequence().new Solution();        // TO TEST
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(solution.lengthOfLIS(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 贪心+二分
         *
         * @param nums
         * @return
         */
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) return 0;
            int[] arr = new int[nums.length];
            int index = 0;
            arr[index] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > arr[index]) {
                    arr[++index] = nums[i];
                } else {
                    int pos = Arrays.binarySearch(arr, 0, index+1, nums[i]);
                    if (pos < 0) arr[-pos - 1] = nums[i];
                }
            }
            return index+1;
        }

//        /**
//         * 动态规划
//         *
//         * @param nums
//         * @return
//         */
//        public int lengthOfLIS(int[] nums) {
//            if (nums.length == 0) return 0;
//            int[] dp = new int[nums.length];
//            Arrays.fill(dp, 1);
//            int max = 1;
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = 0; j < i; j++) {
//                    if (nums[j] < nums[i]) {
//                        dp[i] = Math.max(dp[i], dp[j] + 1);
//                    }
//                }
//                if (dp[i] > max) max = dp[i];
//            }
//            return max;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}