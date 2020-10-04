package leetcode.editor.cn.weeklyCompetion.O209;

import org.junit.Test;

//Java：周赛
//WA 暂时不想看
public class WACompetition4 {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new WACompetition4().new Solution();
        System.out.println(solution.minimumOneBitOperations(9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumOneBitOperations(int n) {
            int cnt = 0;
            int tmp = n;
            while (n != 0) {
                cnt++;
                n = method1(n);
                if (n == 0) break;
                n = method2(n);
                cnt++;
                if (cnt >= (1 << 10)) break;
            }
            if (cnt >= (1 << 10)) {
                cnt = 0;
                n = tmp;
                while (n != 0) {
                    cnt++;
                    n = method2(n);
                    if (n == 0) break;
                    n = method1(n);
                    cnt++;
                }
            }
            return cnt;
        }

        private int method1(int n) {
            if (n % 2 == 0) return n + 1;
            else return n - 1;
        }

        private int method2(int n) {
            int i = 0;
            while ((n & (1 << i)) != (1 << i)) {
                i++;
            }
            i++;
            if (((1 << i) & n) == (1 << i)) {
                n = n - (1 << i);
            } else {
                n = n + (1 << i);
            }
            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}