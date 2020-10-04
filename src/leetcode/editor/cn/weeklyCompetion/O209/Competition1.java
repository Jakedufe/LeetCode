package leetcode.editor.cn.weeklyCompetion.O209;

import org.junit.Test;

//Java：周赛
//2020-09-19 15:09:18
public class Competition1 {

    @Test
    public void testResult() {
        //TO TEST


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int specialArray(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int x = 0;
                for (int j = 0; j < n; j++) {
                    if (nums[j] >= i+1) x++;
                }
                if (x == i+1) return i+1;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}