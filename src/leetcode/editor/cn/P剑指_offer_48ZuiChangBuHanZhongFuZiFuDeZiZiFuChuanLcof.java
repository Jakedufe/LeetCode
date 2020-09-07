//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 双指针 Sliding Window 
// 👍 79 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;

//Java：最长不含重复字符的子字符串
public class P剑指_offer_48ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P剑指_offer_48ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            int n = s.length();
            int max = 0;
            int span = 0;
            HashMap<Character, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                int pos;
                if (hashMap.containsKey(c)) {
                    pos = hashMap.get(c);
                    if (i - pos <= span) span = i - pos;
                    else span++;
                    hashMap.put(c,i);
                } else {
                    hashMap.put(c, i);
                    span++;
                }
                if (span > max) max = span;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}