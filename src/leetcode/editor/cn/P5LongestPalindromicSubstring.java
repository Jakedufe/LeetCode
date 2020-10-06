//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2762 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：最长回文子串
//2020-10-06 15:43:13
public class P5LongestPalindromicSubstring {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 马拉车
         *
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            int n = s.length();
            StringBuilder stringBuilder = new StringBuilder("#");
            for (int i = 0; i < n; i++) {
                stringBuilder.append(s.charAt(i)).append("#");
            }
            s = stringBuilder.toString();
            n = s.length();
            int[] dp = new int[n];
            int center = -1;
            int maxRight = 0;
            int ansPos = 0;
            int maxLen = 0;
            for (int i = 0; i < n; i++) {
                int len = 0;
                if (i < maxRight) {
                    len = Math.min(dp[center * 2 - i], maxRight - i);
                }
                while (i - len >= 0 && i + len < n && s.charAt(i - len) == s.charAt(i + len)) {
                    len++;
                }
                dp[i] = len - 1;
                if (i + dp[i] > maxRight) {
                    maxRight = i + dp[i];
                    center = i;
                }
                if (dp[i] > maxLen) {
                    maxLen = dp[i];
                    ansPos = i;
                }
            }
            StringBuilder stringBuilder1 = new StringBuilder();
            String substring = s.substring(ansPos - maxLen, ansPos + maxLen + 1);
            for (int i = 0; i < substring.length(); i++) {
                if (substring.charAt(i) != '#') stringBuilder1.append(substring.charAt(i));
            }
            return stringBuilder1.toString();
        }

//        /**
//         * 垃圾方法
//         *
//         * @param s
//         * @return
//         */
//        public String longestPalindrome(String s) {
//            int n = s.length();
//            boolean[][] dp = new boolean[n][n];
//            String ans = "";
//            for (int len = 0; len < n; ++len) {
//                for (int i = 0; i + len < n; ++i) {
//                    int j = i + len;
//                    if (len == 0) {
//                        dp[i][j] = true;
//                    } else if (len == 1) {
//                        dp[i][j] = (s.charAt(i) == s.charAt(j));
//                    } else {
//                        dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
//                    }
//                    if (dp[i][j] && len + 1 > ans.length()) {
//                        ans = s.substring(i, i + len + 1);
//                    }
//                }
//            }
//            return ans;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}