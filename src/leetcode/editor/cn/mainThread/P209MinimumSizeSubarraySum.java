//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回
// 0。 
//
// 
//
// 示例： 
//
// 输入：s = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 452 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

//Java：长度最小的子数组
//2020-09-22 21:06:02
public class P209MinimumSizeSubarraySum {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P209MinimumSizeSubarraySum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int r = 0;
            int sum = 0;
            int min = Integer.MAX_VALUE;
            int l = 0;
            while (r < nums.length || (sum >= s && l < nums.length)) {
                if (sum >= s) {
                    min = Math.min(min, r - l);
                    sum -= nums[l++];
                } else {
                    sum += nums[r++];
                }
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}