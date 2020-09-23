//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 示例 1: 
//
// 输入: n = 12
//输出: 3 
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划 
// 👍 602 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：完全平方数
//2020-09-23 21:28:52
public class P279PerfectSquares {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P279PerfectSquares().new Solution();
        System.out.println(solution.numSquares(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        protected boolean isSquare(int n) {
            int sq = (int) Math.sqrt(n);
            return n == sq * sq;
        }

        public int numSquares(int n) {
            // four-square and three-square theorems.
            while (n % 4 == 0)
                n /= 4;
            if (n % 8 == 7)
                return 4;

            if (this.isSquare(n))
                return 1;
            // enumeration to check if the number can be decomposed into sum of two squares.
            for (int i = 1; i * i <= n; ++i) {
                if (this.isSquare(n - i * i))
                    return 2;
            }
            // bottom case of three-square theorem.
            return 3;

        }

//        public int numSquares(int n) {
//            Deque<Integer> queue = new LinkedList<>();
//            List<Integer> list = new LinkedList<>();
//            int index = 1;
//            while (index * index <= n) {
//                list.add(index * index);
//                index++;
//            }
//            int count = 0;
//            queue.offer(n);
//            while (!queue.isEmpty()) {
//                int size = queue.size();
//                Set<Integer> set = new HashSet<>();
//                for (int i = 0; i < size; i++) {
//                    Integer poll = queue.poll();
//                    if (poll == 0) {
//                        return count;
//                    }
//                    for (int j = list.size() - 1; j >= 0; j--) {
//                        int enQueue = poll - list.get(j);
//                        if (poll >= list.get(j) && !set.contains(enQueue)) {
//                            set.add(enQueue);
//                            queue.offer(enQueue);
//                        }
//                    }
//                }
//                count++;
//            }
//            return count;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}