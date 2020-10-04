//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。 
//
// 示例 1: 
//
// 
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: "aba"
//
//输出: False
// 
//
// 示例 3: 
//
// 
//输入: "abcabcabcabc"
//
//输出: True
//
//解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
// 
// Related Topics 字符串 
// 👍 374 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：重复的子字符串
//2020-10-04 17:51:26
public class P459RepeatedSubstringPattern {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P459RepeatedSubstringPattern().new Solution();
        System.out.println(solution.repeatedSubstringPattern("aba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * KMP
         *
         * @param s
         * @return
         */
        public boolean repeatedSubstringPattern(String s) {
            return KMP((s + s).substring(1, s.length() * 2 - 1), s);
        }

        private boolean KMP(String s, String substring) {
            int[] next = getNext(substring);
            int i = 0;
            int j = 0;
            while (j < substring.length() && i < s.length()) {
                if (j < 0 || s.charAt(i) == substring.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j = next[j];
                }
            }
            if (j == substring.length()) return true;
            return false;
        }

        private int[] getNext(String s) {
            int n = s.length();
            int[] next = new int[n];
            int i = 0;
            int j = -1;
            next[i] = j;
            while (i < n - 1) {
                if (j < 0 || s.charAt(i) == s.charAt(j)) {
                    i++;
                    j++;
                    next[i] = j;
                } else {
                    j = next[j];
                }
            }
            return next;
        }

//        /**
//         * 经典解法
//         *
//         * @param s
//         * @return
//         */
//        public boolean repeatedSubstringPattern(String s) {
//            return (s + s).indexOf(s, 1) != s.length();
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}