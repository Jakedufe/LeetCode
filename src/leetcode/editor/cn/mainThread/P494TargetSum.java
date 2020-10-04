//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 
//
// 示例： 
//
// 输入：nums: [1, 1, 1, 1, 1], S: 3
//输出：5
//解释：
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 
//
// 提示： 
//
// 
// 数组非空，且长度不会超过 20 。 
// 初始的数组的和不会超过 1000 。 
// 保证返回的最终结果能被 32 位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 408 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

import java.util.Arrays;

//Java：目标和
//2020-09-24 14:27:04
public class P494TargetSum {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P494TargetSum().new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findTargetSumWays(int[] nums, int S) {
            int[] dp = new int[2001];
            int[] next = new int[2001];
            dp[1000 + nums[0]] = 1;
            dp[1000 - nums[0]] += 1;
            for (int i = 1; i < nums.length; i++) {
                Arrays.fill(next, 0);
                for (int j = 0; j < 2001; j++) {
                    if (dp[j] > 0) {
                        next[j + nums[i]] += dp[j];
                        next[j - nums[i]] += dp[j];
                    }
                }
                int[] tmp = dp;
                dp = next;
                next = tmp;
            }
            return S > 1000 ? 0 : dp[1000 + S];
        }


//        private int count = 0;
//
//        public int findTargetSumWays(int[] nums, int S) {
//            dfs(nums, S, 0, 0);
//            return count;
//        }
//
//        private void dfs(int[] nums, int S, int pos, int total) {
//            if (pos == nums.length) {
//                if (total == S) count++;
//                return;
//            }
//            int i = pos;
//            dfs(nums, S, i + 1, total + nums[i]);
//            dfs(nums, S, i + 1, total - nums[i]);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}