//小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小
//A 猜对了几次？ 
//
// 
//
// 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。 
//
// 
//
// 示例 1： 
//
// 输入：guess = [1,2,3], answer = [1,2,3]
//输出：3
//解释：小A 每次都猜对了。 
//
// 
//
// 示例 2： 
//
// 输入：guess = [2,2,3], answer = [3,2,1]
//输出：1
//解释：小A 只猜对了第二次。 
//
// 
//
// 限制： 
//
// 
// guess的长度 = 3 
// answer的长度 = 3 
// guess的元素取值为 {1, 2, 3} 之一。 
// answer的元素取值为 {1, 2, 3} 之一。 
// 
// 👍 112 👎 0


package leetcode.editor.cn.weeklyCompetion;

import org.junit.Test;

//Java：猜数字
//2020-09-19 15:09:18
public class teamCompetition1 {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new teamCompetition1().new Solution();
//        for (int i = 1; i < 7; i++) {
//            for (int j = 0; j <= i * i; j++) {
//                System.out.print(new teamCompetition1().new Solution().paintingPlan(i, j) + " ");
//            }
//            System.out.println();
//        }
        System.out.print(solution.paintingPlan(2, 3) + " ");

    }

    //0 1
//0 0 4 4 1
//0 0 0 6 0 9 6 18 9 1
//0 0 0 0 8 0 0 16 12 0 48 0 36 32 48 16 1
//0 0 0 0 0 10 0 0 0 25 20 0 0 100 0 20 100 100 0 200 10 100 100 100 25 1
//0 0 0 0 0 0 12 0 0 0 0 36 30 0 0 0 180 0 40 0 225 240 0 0 600 0 180 400 450 0 600 72 225 240 180 36 1
//0 1
//0 0 4 4 1
//0 0 0 6 0 9 6 18 9 1
//0 0 0 0 8 0 0 16 12 0 48 0 8 32 48 16 1
//0 0 0 0 0 10 0 0 0 25 20 0 0 100 0 20 100 100 0 200 10 50 100 100 25 1
//0 0 0 0 0 0 12 0 0 0 0 36 30 0 0 0 180 0 40 0 225 240 0 0 30 0 180 400 450 0 12 72 180 240 180 36 1
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[] r = new boolean[6];
        boolean[] c = new boolean[6];

        int total = 0;
        int K;

        public int paintingPlan(int n, int k) {
            K = k;
            boolean[][] map = new boolean[6][6];
            dfs(n, map);
            return total;
        }

        private void dfs(int n, boolean[][] map) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j]) count++;
                }
            }
            if (K == count) {
                total++;
                return;
            }
            if (count > K) return;

            for (int i = 0; i < n; i++) {
                if (!r[i]) {
                    r[i] = true;
                    boolean[][] tmp = new boolean[n][n];
                    for (int j = 0; j < n; j++) {
                        System.arraycopy(map[j], 0, tmp[j], 0, n);
                    }
                    for (int j = 0; j < n; j++) {
                        tmp[j][i] = true;
                    }
                    dfs(n, tmp);
                    r[i] = false;
                }
                if (!c[i]) {
                    c[i] = true;
                    boolean[][] tmp = new boolean[n][n];
                    for (int j = 0; j < n; j++) {
                        System.arraycopy(map[j], 0, tmp[j], 0, n);
                    }
                    for (int j = 0; j < n; j++) {
                        tmp[i][j] = true;
                    }
                    dfs(n, tmp);
                    c[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}