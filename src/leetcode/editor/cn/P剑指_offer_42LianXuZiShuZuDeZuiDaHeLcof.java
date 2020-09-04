//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划 
// 👍 115 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：连续子数组的最大和
public class P剑指_offer_42LianXuZiShuZuDeZuiDaHeLcof {

    @Test
    public void testResult() {
        Solution solution = new P剑指_offer_42LianXuZiShuZuDeZuiDaHeLcof().new Solution();        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
//            int max = -100;
//            int sum = -100;
//            boolean flag = true;
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] >= 0) flag = false;
//            }
//            for (int i = 0; i < nums.length; i++) {
//                if (sum + nums[i] > 0) {
//                    sum += nums[i];
//                } else if (nums[i] < 0) {
//                    if (flag) {
//                        sum = nums[i];
//                    } else
//                        sum = 0;
//                } else if (nums[i] >= 0) {
//                    sum = nums[i];
//                }
//                if (sum > max) max = sum;
//            }
//            return max;
            int res = nums[0];
            for(int i = 1; i < nums.length; i++) {
                nums[i] += Math.max(nums[i - 1], 0);
                res = Math.max(res, nums[i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}