//假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？ 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 10^5 
//
// 
//
// 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-s
//tock/ 
// Related Topics 动态规划 
// 👍 52 👎 0


package leetcode.editor.cn.offerFirstTime;

import org.junit.Test;

//Java：股票的最大利润
//2020-09-17 16:49:10
public class P剑指_offer_63GuPiaoDeZuiDaLiRunLcof {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P剑指_offer_63GuPiaoDeZuiDaLiRunLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) return 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int MAX = Integer.MIN_VALUE;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                    max = prices[i];
                } else if (prices[i] > max) {
                    max = prices[i];
                }
                MAX = Math.max(MAX, max - min);
            }
            return MAX;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}