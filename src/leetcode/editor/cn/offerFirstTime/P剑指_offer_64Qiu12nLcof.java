//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。 
//
// 
//
// 示例 1： 
//
// 输入: n = 3
//输出: 6
// 
//
// 示例 2： 
//
// 输入: n = 9
//输出: 45
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10000 
// 
// 👍 203 👎 0


package leetcode.editor.cn.offerFirstTime;

import org.junit.Test;

//Java：求1+2+…+n
//2020-09-18 15:07:36
public class P剑指_offer_64Qiu12nLcof {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P剑指_offer_64Qiu12nLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumNums(int n) {
            boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}