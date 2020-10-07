//给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例： 
//
// 输入: "sea", "eat"
//输出: 2
//解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
// 
//
// 
//
// 提示： 
//
// 
// 给定单词的长度不超过500。 
// 给定单词中的字符只含有小写字母。 
// 
// Related Topics 字符串 
// 👍 148 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：两个字符串的删除操作
//2020-10-07 19:31:43
public class P583DeleteOperationForTwoStrings {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P583DeleteOperationForTwoStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 动态规划最小删除次数
         *
         * @param word1
         * @param word2
         * @return
         */
        public int minDistance(String word1, String word2) {
            int m = word1.length() + 1;
            int n = word2.length() + 1;
            //word1前i个字符和word2前j个字符的最小删除次数
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = i + j;
                        continue;
                    }
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
//        /**
//         * 动态规划最长公共子序列
//         *
//         * @param word1
//         * @param word2
//         * @return
//         */
//        public int minDistance(String word1, String word2) {
//            int m = word1.length() + 1;
//            int n = word2.length() + 1;
//            //word1前i个字符和word2前j个字符的最长公共子序列
//            int[][] dp = new int[m][n];
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (i == 0 || j == 0) continue;
//                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                        dp[i][j] = dp[i - 1][j - 1] + 1;
//                    } else {
//                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                    }
//                }
//            }
//            return word1.length() + word2.length() - 2 * dp[m - 1][n - 1];
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}