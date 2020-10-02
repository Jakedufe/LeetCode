//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 776 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：乘积最大子数组
//2020-10-01 19:42:30
public class P152MaximumProductSubarray {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P152MaximumProductSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            if (nums.length == 0) return 0;
            int[] positive = new int[nums.length];
            int[] negative = new int[nums.length];
            positive[0] = Math.max(nums[0], 0);
            negative[0] = Math.min(nums[0], 0);
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0) {
                    positive[i] = 0;
                    negative[i] = 0;
                } else {
                    int positiveVal = positive[i - 1] == 0 ? 1 : positive[i - 1];
                    if (nums[i] > 0) {
                        positive[i] = positiveVal * nums[i];
                        negative[i] = (negative[i - 1]) * nums[i];
                    } else {
                        positive[i] = negative[i - 1] * nums[i];
                        negative[i] = positiveVal * nums[i];
                    }
                }
                max = Math.max(max, positive[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}