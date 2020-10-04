//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 575 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

//Java：实现 strStr()
//2020-09-22 18:10:43
public class P28ImplementStrstr {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P28ImplementStrstr().new Solution();
        System.out.println(solution.strStr("a", "a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle == null || needle.equals("")) return 0;
            int[] next = getNext(needle);
            int i = 0;
//            细节
            int j = 0;
            while (j < needle.length() && i < haystack.length()) {
                if (j < 0 || haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j = next[j];
                }
            }
            if (j == needle.length()) return i - j;
            else return -1;
        }

        private int[] getNext(String s) {
            int n = s.length();
            int[] next = new int[n];
            int i = 0;
            int j = -1;
            next[i] = j;
//            细节
//            i < n - 1
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
    }
//leetcode submit region end(Prohibit modification and deletion)

}