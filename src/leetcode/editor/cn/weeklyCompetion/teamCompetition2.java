package leetcode.editor.cn.weeklyCompetion;

import org.junit.Test;

//Java：周赛
//2020-09-19 15:09:18
public class teamCompetition2 {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new teamCompetition2().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
            int waiting = 0;
            int max = Integer.MIN_VALUE;
            int buyer = 0;
            int round = 0;
            int res = 0;
            for (int i = 0; i < customers.length; i++) {
                waiting += customers[i];
                if (waiting > 4) {
                    buyer += 4;
                    waiting -= 4;
                } else {
                    buyer += waiting;
                    waiting = 0;
                }
                round++;
                if (max < buyer * boardingCost - round * runningCost) {
                    max = buyer * boardingCost - round * runningCost;
                    res = round;
                }
            }
            while (waiting != 0) {
                if (waiting > 4) {
                    buyer += 4;
                    waiting -= 4;
                } else {
                    buyer += waiting;
                    waiting = 0;
                }
                round++;
                if (max < buyer * boardingCost - round * runningCost) {
                    max = buyer * boardingCost - round * runningCost;
                    res = round;
                }
            }
            return max < 0 ? -1 : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}