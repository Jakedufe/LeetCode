package leetcode.editor.cn.weeklyCompetion.D36;

import org.junit.Test;

//Java：周赛
//2020-09-19 15:09:18
public class Competition3 {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new Competition3().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
            int m = rowSum.length;
            int n = colSum.length;
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int min = Math.min(rowSum[i], colSum[j]);
                    arr[i][j] = min;
                    rowSum[i] -= min;
                    colSum[j] -= min;
                }
            }
            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}