//给你一个大小为 rows x cols 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。 
//
// 在从左上角 (0, 0) 开始到右下角 (rows - 1, cols - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单
//元格中所有整数的乘积。 
//
// 返回 最大非负积 对 109 + 7 取余 的结果。如果最大积为负数，则返回 -1 。 
//
// 注意，取余是在得到最大积之后执行的。 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[-1,-2,-3],
//             [-2,-3,-3],
//             [-3,-3,-2]]
//输出：-1
//解释：从 (0, 0) 到 (2, 2) 的路径中无法得到非负积，所以返回 -1
// 
//
// 示例 2： 
//
// 输入：grid = [[1,-2,1],
//             [1,-2,1],
//             [3,-4,1]]
//输出：8
//解释：最大非负积对应的路径已经用粗体标出 (1 * 1 * -2 * -4 * 1 = 8)
// 
//
// 示例 3： 
//
// 输入：grid = [[1, 3],
//             [0,-4]]
//输出：0
//解释：最大非负积对应的路径已经用粗体标出 (1 * 0 * -4 = 0)
// 
//
// 示例 4： 
//
// 输入：grid = [[ 1, 4,4,0],
//             [-2, 0,0,1],
//             [ 1,-1,1,1]]
//输出：2
//解释：最大非负积对应的路径已经用粗体标出 (1 * -2 * 1 * -1 * 1 * 1 = 2)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= rows, cols <= 15 
// -4 <= grid[i][j] <= 4 
// 
// Related Topics 贪心算法 动态规划 
// 👍 4 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：矩阵的最大非负积
//2020-09-20 15:29:45
public class P5521MaximumNonNegativeProductInAMatrix {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P5521MaximumNonNegativeProductInAMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProductPath(int[][] grid) {

            int n = grid.length;
            int m = grid[0].length;
            long[][] positiveDp = new long[n][m];
            long[][] negativeDp = new long[n][m];

            positiveDp[n - 1][m - 1] = grid[n - 1][m - 1];
            negativeDp[n - 1][m - 1] = grid[n - 1][m - 1];
            for (int i = n - 2; i >= 0; i--) {
                positiveDp[i][m - 1] = grid[i][m - 1] * positiveDp[i + 1][m - 1];
                negativeDp[i][m - 1] = grid[i][m - 1] * negativeDp[i + 1][m - 1];
            }
            for (int i = m - 2; i >= 0; i--) {
                positiveDp[n - 1][i] = grid[n - 1][i] * positiveDp[n - 1][i + 1];
                negativeDp[n - 1][i] = grid[n - 1][i] * negativeDp[n - 1][i + 1];
            }

            for (int i = n - 2; i >= 0; i--) {
                for (int j = m - 2; j >= 0; j--) {
                    if (grid[i][j] >= 0) {
                        positiveDp[i][j] = grid[i][j] * Math.max(positiveDp[i + 1][j], positiveDp[i][j + 1]);
                        negativeDp[i][j] = grid[i][j] * Math.min(negativeDp[i + 1][j], negativeDp[i][j + 1]);
                    } else {
                        negativeDp[i][j] = grid[i][j] * Math.max(positiveDp[i + 1][j], positiveDp[i][j + 1]);
                        positiveDp[i][j] = grid[i][j] * Math.min(negativeDp[i + 1][j], negativeDp[i][j + 1]);
                    }
                }
            }

            return positiveDp[0][0] < 0 ? -1 : (int) (positiveDp[0][0] % 1000000007);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {
        long max = -1;

        public int maxProductPath(int[][] grid) {
            dfs(grid, 0, 0, grid[0][0]);
            return (int) (max % 1000000007);
        }

        private void dfs(int[][] grid, int x, int y, long total) {
//            total = total % 1000000007;
            if (x == grid.length - 1 && y == grid[0].length - 1) {
                if (total >= 0) max = Math.max(total, max);
                return;
            }
            int[][] moves = {
                    {1, 0}, {0, 1},
            };
            for (int[] move : moves) {
                int r = x + move[0];
                int c = y + move[1];
                if (inArea(grid, r, c)) {
                    dfs(grid, r, c, total * grid[r][c]);
                }
            }

        }

        // 判断坐标 (r, c) 是否在网格中
        boolean inArea(int[][] grid, int r, int c) {
            return 0 <= r && r < grid.length
                    && 0 <= c && c < grid[0].length;
        }
    }
}