//给你一个字符串 s ，请你拆分该字符串，并返回拆分后唯一子字符串的最大数目。 
//
// 字符串 s 拆分后可以得到若干 非空子字符串 ，这些子字符串连接后应当能够还原为原字符串。但是拆分出来的每个子字符串都必须是 唯一的 。 
//
// 注意：子字符串 是字符串中的一个连续字符序列。 
//
// 
//
// 示例 1： 
//
// 输入：s = "ababccc"
//输出：5
//解释：一种最大拆分方法为 ['a', 'b', 'ab', 'c', 'cc'] 。像 ['a', 'b', 'a', 'b', 'c', 'cc'] 这样
//拆分不满足题目要求，因为其中的 'a' 和 'b' 都出现了不止一次。
// 
//
// 示例 2： 
//
// 输入：s = "aba"
//输出：2
//解释：一种最大拆分方法为 ['a', 'ba'] 。
// 
//
// 示例 3： 
//
// 输入：s = "aa"
//输出：1
//解释：无法进一步拆分字符串。
// 
//
// 
//
// 提示： 
//
// 
// 
// 1 <= s.length <= 16 
// 
// 
// s 仅包含小写英文字母 
// 
// 
// Related Topics 回溯算法 
// 👍 3 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//Java：拆分字符串使唯一子字符串的数目最大
//2020-09-20 15:09:20
public class P5520SplitAStringIntoTheMaxNumberOfUniqueSubstrings {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P5520SplitAStringIntoTheMaxNumberOfUniqueSubstrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int max = 1;
        Set<String> set = new HashSet<>();

        public int maxUniqueSplit(String s) {
            dfs(s, 0);
            return max;
        }

        private void dfs(String s, int start) {
            if (s.length()  == start) {
                max = Math.max(set.size(),max);
                return;
            }
            for (int end = start + 1; end <= s.length(); end++) {
                String substring = s.substring(start, end);
                if (!set.contains(substring)) {
                    set.add(substring);
                    dfs(s, end);
                    set.remove(substring);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}