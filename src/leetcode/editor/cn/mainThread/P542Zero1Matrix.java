//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 示例 1: 
//输入: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 示例 2: 
//输入: 
//
// 
//0 0 0
//0 1 0
//1 1 1
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//1 2 1
// 
//
// 注意: 
//
// 
// 给定矩阵的元素个数不超过 10000。 
// 给定矩阵中至少有一个元素是 0。 
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 317 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

//Java：01 矩阵
//2020-09-24 17:01:04
public class P542Zero1Matrix {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P542Zero1Matrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            int[][] re = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        re[i][j] = 0;
                    } else re[i][j] = Integer.MAX_VALUE / 2;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    re[i][j] = Math.min(re[i][j],
                            Math.min(inArea(matrix, i - 1, j) ? re[i - 1][j] : Integer.MAX_VALUE / 2,
                                    inArea(matrix, i, j - 1) ? re[i][j - 1] : Integer.MAX_VALUE / 2) + 1);
                }
            }
            for (int i = matrix.length - 1; i >= 0; i--) {
                for (int j = matrix[0].length - 1; j >= 0; j--) {
                    re[i][j] = Math.min(re[i][j],
                            Math.min(inArea(matrix, i + 1, j) ? re[i + 1][j] : Integer.MAX_VALUE / 2,
                                    inArea(matrix, i, j + 1) ? re[i][j + 1] : Integer.MAX_VALUE / 2) + 1);
                }
            }
            return re;
        }
//        public int[][] updateMatrix(int[][] matrix) {
//            int[][] re = new int[matrix.length][matrix[0].length];
//            boolean[][] visited = new boolean[matrix.length][matrix[0].length];
//            Deque<int[]> queue = new LinkedList<>();
//            for (int i = 0; i < matrix.length; i++) {
//                for (int j = 0; j < matrix[0].length; j++) {
//                    if (matrix[i][j] == 0) {
//                        queue.offer(new int[]{i, j});
//                        visited[i][j] = true;
//                        re[i][j] = 0;
//                    }
//                }
//            }
//            int index = 1;
//            int[][] moves = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//            while (!queue.isEmpty()) {
//                int size = queue.size();
//                for (int i = 0; i < size; i++) {
//                    int[] poll = queue.poll();
//                    for (int[] move : moves) {
//                        int r = poll[0] + move[0];
//                        int c = poll[1] + move[1];
//                        if (inArea(matrix, r, c) && !visited[r][c]) {
//                            re[r][c] = index;
//                            visited[r][c] = true;
//                            queue.add(new int[]{r, c});
//                        }
//                    }
//                }
//                index++;
//            }
//            return re;
//        }

        private boolean inArea(int[][] arr, int r, int c) {
            return r >= 0 && r < arr.length
                    && c >= 0 && c < arr[0].length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}