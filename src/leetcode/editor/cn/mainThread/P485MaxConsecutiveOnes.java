//给定一个二进制数组， 计算其中最大连续1的个数。 
//
// 示例 1: 
//
// 
//输入: [1,1,0,1,1,1]
//输出: 3
//解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
// 
//
// 注意： 
//
// 
// 输入的数组只包含 0 和1。 
// 输入数组的长度是正整数，且不超过 10,000。 
// 
// Related Topics 数组 
// 👍 125 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

//Java：最大连续1的个数
//2020-09-22 20:57:16
public class P485MaxConsecutiveOnes {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P485MaxConsecutiveOnes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int stamp = -1;
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) continue;
                max = Math.max(max, i - stamp - 1);
                stamp = i;
            }
            max = Math.max(max, nums.length - stamp - 1);
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}