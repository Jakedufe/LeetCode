//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1275 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

//Java：最长公共前缀
//2020-09-22 14:23:59
public class P14LongestCommonPrefix {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P14LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            int min = Integer.MAX_VALUE;
            String s = "";
            String res = "";
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() < min) {
                    min = strs[i].length();
                    s = strs[i];
                }
            }
            if (s.equals("")) return res;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < strs.length; j++) {
                    if (strs[j].charAt(i) != s.charAt(i)) {
                        res = s.substring(0, i);
                        return res;
                    }
                }
            }
            return s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}