package leetcode.editor.cn.weeklyCompetion.O208;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

//Java：周赛
//2020-09-19 15:09:18
public class Competition1 {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new Competition1().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(String[] logs) {
            int n = logs.length;
            Deque<String> stack = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                String substring = logs[i].substring(0, logs[i].length() - 1);
                if (".".equals(substring)) continue;
                if ("..".equals(substring)) {
                    if (!stack.isEmpty())
                        stack.pop();
                } else stack.push(substring);
            }
            return stack.isEmpty() ? 0 : stack.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}