//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
//是 4 次，则需要在最终答案中包含该字符 3 次。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 输入：["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 100 
// 1 <= A[i].length <= 100 
// A[i][j] 是小写字母 
// 
// Related Topics 数组 哈希表 
// 👍 170 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：查找常用字符
//2020-10-14 21:43:16
public class P1002FindCommonCharacters {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P1002FindCommonCharacters().new Solution();
        String[] arr = new String[]{"bella", "label", "roller"};
//        System.out.println(solution.commonChars(arr));
        for (String commonChar : solution.commonChars(arr)) {
            System.out.println(commonChar);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> commonChars(String[] A) {
            int len = 26;
            int[] hash = new int[len];
            int[] tmp = new int[len];
            Arrays.fill(hash, Integer.MAX_VALUE);
            for (int i = 0; i < A.length; i++) {
                Arrays.fill(tmp, 0);
                for (int j = 0; j < A[i].length(); j++) {
                    tmp[A[i].charAt(j) - 'a']++;
                }
                for (int j = 0; j < len; j++) {
                    hash[j] = Math.min(hash[j], tmp[j]);
                }
            }
            List<String> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                while (hash[i]-- > 0) {
                    char s = (char) ('a' + i);
                    list.add(Character.toString(s));
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}