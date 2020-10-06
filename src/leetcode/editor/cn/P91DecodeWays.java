//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 题目数据保证答案肯定是一个 32 位的整数。 
//
// 
//
// 示例 1： 
//
// 输入："12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 输入："226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 输入：s = "0"
//输出：0
// 
//
// 示例 4： 
//
// 输入：s = "1"
//输出：1
// 
//
// 示例 5： 
//
// 输入：s = "2"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可以包含前导零。 
// 
// Related Topics 字符串 动态规划 
// 👍 517 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：解码方法
//2020-10-06 12:34:10
public class P91DecodeWays {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P91DecodeWays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            int n = s.length();
            if (n == 0) return 0;
            int[][] dp = new int[n][2];
            dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
            dp[0][1] = 0;
            if (n == 1) return dp[0][0];
            dp[1][0] = s.charAt(1) == '0' ? 0 : dp[0][0];
            int parseInt = Integer.parseInt(s.substring(0, 2));
            dp[1][1] = parseInt >= 10 && parseInt < 27 ? 1 : 0;
            for (int i = 2; i < n; i++) {
                if (s.charAt(i) == '0') {
                    dp[i][0] = 0;
                } else {
                    dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
                }
                int anInt = Integer.parseInt(s.substring(i - 1, i + 1));
                if (anInt >= 10 && anInt < 27) {
                    dp[i][1] = dp[i - 2][0] + dp[i - 2][1];
                } else {
                    dp[i][1] = 0;
                }
            }
            return dp[n - 1][0] + dp[n - 1][1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}