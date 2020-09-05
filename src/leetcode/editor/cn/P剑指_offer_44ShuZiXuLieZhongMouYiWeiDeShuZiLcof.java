//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 
// 👍 54 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：数字序列中某一位的数字
public class P剑指_offer_44ShuZiXuLieZhongMouYiWeiDeShuZiLcof {

    @Test
    public void testResult() {
        Solution solution = new P剑指_offer_44ShuZiXuLieZhongMouYiWeiDeShuZiLcof().new Solution();        // TO TEST
        System.out.println(solution.findNthDigit(11));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNthDigit(int n) {
            int digit = 1;
            int start = 1;
            int count = 9;
            while (count > 0 && n > count) {
                n = n - count;
                digit++;
                start *= 10;
                count = start * digit * 9;
            }
            int num = start + (n - 1) / digit;
            int index = (n - 1) % digit;
            String s = String.valueOf(num);
            return s.charAt(index) - '0';
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}