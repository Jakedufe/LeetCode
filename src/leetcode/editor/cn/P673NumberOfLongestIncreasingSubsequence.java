//给定一个未排序的整数数组，找到最长递增子序列的个数。 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。 
// Related Topics 动态规划 
// 👍 214 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

//Java：最长递增子序列的个数
//2020-10-01 15:55:13
public class P673NumberOfLongestIncreasingSubsequence {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P673NumberOfLongestIncreasingSubsequence().new Solution();
        System.out.println(solution.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(solution.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length;
            int re = 0;
            int[] lengths = new int[n];
            int[] counts = new int[n];
            Arrays.fill(lengths, 1);
            Arrays.fill(counts, 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        if (lengths[j] + 1 > lengths[i]) {
                            lengths[i] = lengths[j] + 1;
                            counts[i] = counts[j];
                        } else if (lengths[j] + 1 == lengths[i]) {
                            counts[i] += counts[j];
                        }
                    }
                }
            }
            int maxLen = 0;
            for (int i = 0; i < n; i++) {
                maxLen = Math.max(maxLen, lengths[i]);
            }
            for (int i = 0; i < n; i++) {
                if (lengths[i] == maxLen) {
                    re += counts[i];
                }
            }
            return re;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}