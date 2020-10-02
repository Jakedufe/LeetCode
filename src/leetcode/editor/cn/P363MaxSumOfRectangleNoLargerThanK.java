//给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。 
//
// 示例: 
//
// 输入: matrix = [[1,0,1],[0,-2,3]], k = 2
//输出: 2 
//解释: 矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
// 
//
// 说明： 
//
// 
// 矩阵内的矩形区域面积必须大于 0。 
// 如果行数远大于列数，你将如何解答呢？ 
// 
// Related Topics 队列 二分查找 动态规划 
// 👍 126 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

//Java：矩形区域不超过 K 的最大数值和
//2020-10-02 19:19:51
public class P363MaxSumOfRectangleNoLargerThanK {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P363MaxSumOfRectangleNoLargerThanK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[] b = new int[n];
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                Arrays.fill(b, 0);
                for (int j = i; j < m; j++) {
                    for (int l = 0; l < n; l++) {
                        b[l] += matrix[j][l];
                    }
                    //O(n) 判断
                    int sum = b[0];
                    int s = b[0];
                    for (int l = 1; l < n; l++) {
                        sum = b[l] + Math.max(sum, 0);
                        s = Math.max(s, sum);
                    }
                    if (s <= k) {
                        if (s > res) {
                            res = s;
                            if (res == k) {
                                return res;
                            }
                        }
                        continue;
                    }

                    for (int l = 0; l < n; l++) {
                        int total = 0;
                        for (int o = l; o < n; o++) {
                            total += b[o];
                            if (total > res && total <= k) {
                                res = total;
                                if (res == k) {
                                    return res;
                                }
                            }
                        }

                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}