//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划 
// 👍 1003 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：最长有效括号
//2020-10-05 20:37:59
public class P32LongestValidParentheses {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P32LongestValidParentheses().new Solution();
        System.out.println(solution.longestValidParentheses("(()())"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int n = s.length();
            int[] dp = new int[n];
            for (int i = 1; i < n; i++) {
                char c = s.charAt(i);
                if (c == '(') continue;
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                    continue;
                }
                int preIndex = i - dp[i - 1] - 1;
                if (preIndex >= 0 && s.charAt(preIndex) == '(') {
                    dp[i] = dp[i - 1] + (preIndex - 1 >= 0 ? dp[preIndex - 1] : 0) + 2;
                }
            }
            int max = 0;
            for (int i : dp) {
                max = Math.max(max, i);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}