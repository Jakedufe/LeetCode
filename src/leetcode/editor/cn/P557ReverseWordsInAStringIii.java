//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 245 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：反转字符串中的单词 III
//2020-09-23 10:22:06
public class P557ReverseWordsInAStringIii {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P557ReverseWordsInAStringIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            String[] split = s.trim().split(" +");
            StringBuilder stringBuilder = new StringBuilder();
            for (String s1 : split) {
                StringBuilder stringBuilder1 = new StringBuilder(s1);
                stringBuilder.append(stringBuilder1.reverse()).append(' ');
            }
            return stringBuilder.toString().trim();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}