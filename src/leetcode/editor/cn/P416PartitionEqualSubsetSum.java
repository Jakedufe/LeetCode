//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 546 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

//Java：分割等和子集
//2020-10-12 14:59:45
public class P416PartitionEqualSubsetSum {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P416PartitionEqualSubsetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            if (n == 0) return false;
            Arrays.sort(nums);
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 == 1) return false;
            sum /= 2;
            if (sum < nums[n - 1]) return false;
            boolean[] dp = new boolean[sum + 1];
            dp[nums[0]] = true;
            dp[0] = true;
            for (int i = 1; i < n; i++) {
                dp[0] = true;
                for (int j = sum; j > 0; j--) {
                    if (j >= nums[i]) {
                        dp[j] = dp[j] | dp[j - nums[i]];
                    }
                }
            }
            return dp[sum];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}