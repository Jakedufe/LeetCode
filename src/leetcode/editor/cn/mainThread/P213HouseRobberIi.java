//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋
//装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
// Related Topics 动态规划 
// 👍 386 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

//Java：打家劫舍 II
//2020-10-02 21:19:22
public class P213HouseRobberIi {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P213HouseRobberIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            if (n == 1) return nums[0];
            if (n == 2) return Math.max(nums[0], nums[1]);
            int[] ans1 = new int[n];
            int[] ans2 = new int[n];
            ans1[0] = 0;
            ans1[1] = nums[1];
            for (int i = 2; i < n; i++) {
                ans1[i] = Math.max(ans1[i - 1], nums[i] + ans1[i - 2]);
            }
            ans2[0] = nums[0];
            ans2[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < n - 1; i++) {
                ans2[i] = Math.max(ans2[i - 1], ans2[i - 2] + nums[i]);
            }
            return Math.max(ans1[n - 1], ans2[n - 2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}