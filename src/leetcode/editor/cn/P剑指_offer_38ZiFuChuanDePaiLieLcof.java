//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 81 👎 0


package leetcode.editor.cn;
import org.junit.Test;
import java.util.*;
//Java：字符串的排列
public class P剑指_offer_38ZiFuChuanDePaiLieLcof{
    
    @Test
    public void testResult() {
        Solution solution = new P剑指_offer_38ZiFuChuanDePaiLieLcof().new Solution();        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        String[] result;
        Set<String> set = new HashSet<>();
        Deque<Character> deque = new LinkedList<>();
        Character[] arr;
        int num;
        boolean[] visited;

    public String[] permutation(String s) {

        arr = new Character[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        num = arr.length;
        visited = new boolean[num];

        process();
        int i = 0;
        result = new String[set.size()];
        for (String s1 : set) {
            result[i++] = s1;
        }

        return result;
    }

        private void process() {

            if (deque.size() == num) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Character character : deque) {
                    stringBuilder.append(character);
                }
                set.add(stringBuilder.toString());
                return;
            }

            for (int i = 0; i < num; i++) {
                if (visited[i]) continue;
                deque.push(arr[i]);
                visited[i] = true;
                process();
                deque.pop();
                visited[i] = false;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}