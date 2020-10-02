//给定一个正整数、负整数和 0 组成的 N × M 矩阵，编写代码找出元素总和最大的子矩阵。 
//
// 返回一个数组 [r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，r2, c2 分别代表右下角的行号和列号。若有多个满
//足条件的子矩阵，返回任意一个均可。 
//
// 注意：本题相对书上原题稍作改动 
//
// 示例： 
//
// 输入：
//[
//   [-1,0],
//   [0,-1]
//]
//输出：[0,1,0,1]
//解释：输入中标粗的元素即为输出所表示的矩阵 
//
// 
//
// 说明： 
//
// 
// 1 <= matrix.length, matrix[0].length <= 200 
// 
// Related Topics 动态规划 
// 👍 30 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：最大子矩阵
//2020-10-02 16:46:24
public class P面试题_1724MaxSubmatrixLcci {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P面试题_1724MaxSubmatrixLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getMaxMatrix(int[][] matrix) {
            int m = matrix.length;
            int[] res = new int[4];
            int n = matrix[0].length;
            int[][] P = new int[m + 1][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    P[j + 1][i] = P[j][i] + matrix[j][i];
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i <= m; i++) {
                for (int j = i + 1; j <= m; j++) {
                    int sum = 0;
                    int start = 0;
                    for (int k = 0; k < n; k++) {
                        if (sum > 0) {
                            sum += P[j][k] - P[i][k];
                        } else {
                            sum = P[j][k] - P[i][k];
                            start = k;
                        }
                        if (sum >= max) {
                            max = sum;
                            res[0] = i;
                            res[1] = start;
                            res[2] = Math.max(j - 1, 0);
                            res[3] = k;
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}