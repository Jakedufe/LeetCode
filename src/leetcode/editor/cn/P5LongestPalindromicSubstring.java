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
// 👍 2706 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：最长回文子串
//2020-09-22 14:46:42
public class P5LongestPalindromicSubstring {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s.equals("")) return "";
            int n = s.length();
            Map<Integer, List<int[]>> hahMap = new HashMap<>();
            List<int[]> list = new ArrayList<>();
            List<int[]> list2 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int[] ints = {i, i + 1};
                list.add(ints);
                if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    int[] ints1 = {i, i + 2};
                    list2.add(ints1);
                }
            }
            hahMap.put(1, list);
            hahMap.put(2, list2);
            int index = 1;
            while (index < n) {
                if (!hahMap.containsKey(index)) {
                    index++;
                    continue;
                }
                List<int[]> listOld = hahMap.get(index);
                index++;
                if (listOld.isEmpty()) continue;
                List<int[]> listNew = new ArrayList<>();
                for (int[] ints : listOld) {
                    int l = ints[0];
                    int r = ints[1];
                    if (l - 1 >= 0 && r < n && s.charAt(l - 1) == s.charAt(r)) {
                        listNew.add(new int[]{l - 1, r + 1});
                    }
                }
                if (!listNew.isEmpty()) hahMap.put(index + 1, listNew);
            }
            index = n;
            while (index > 0) {
                if (hahMap.containsKey(index) && !hahMap.get(index).isEmpty()) {
                    int[] ints = hahMap.get(index).get(0);
                    return s.substring(ints[0], ints[1]);
                }
                index--;
            }
            return s.substring(0, 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}