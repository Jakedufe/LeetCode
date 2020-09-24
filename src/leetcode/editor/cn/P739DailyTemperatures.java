//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
// 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表 
// 👍 514 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：每日温度
//2020-09-24 10:47:52
public class P739DailyTemperatures {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P739DailyTemperatures().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            int[] res = new int[T.length];
            res[T.length - 1] = 0;
            for (int i = T.length - 1; i >= 0; i--) {
                int j = i + 1;
                while (j < T.length) {
                    if (T[i] < T[j]) {
                        res[i] = j - i;
                        break;
                    } else if (res[j] == 0) {
                        res[i] = 0;
                        break;
                    } else {
                        j += res[j];
                    }
                }
            }
            return res;
        }
//        public int[] dailyTemperatures(int[] T) {
//            Deque<Integer> stack = new LinkedList<>();
//            Deque<Integer> hash = new LinkedList<>();
//            int[] res = new int[T.length];
//            for (int i = T.length - 1; i >= 0; i--) {
//                while (!stack.isEmpty() && T[i] >= stack.peek()) {
//                    stack.pop();
//                    hash.pop();
//                }
//                if (!stack.isEmpty() && !hash.isEmpty()) {
//                    res[i] = hash.peek() - i;
//                } else {
//                    res[i] = 0;
//                }
//                stack.push(T[i]);
//                hash.push(i);
//            }
//            return res;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}