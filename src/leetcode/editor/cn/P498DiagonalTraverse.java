//给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。 
//
// 
//
// 示例: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//
//输出:  [1,2,4,7,5,3,6,8,9]
//
//解释:
//
// 
//
// 
//
// 说明: 
//
// 
// 给定矩阵中的元素总数不会超过 100000 。 
// 
// 👍 128 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：对角线遍历
//2020-09-22 13:43:21
public class P498DiagonalTraverse {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P498DiagonalTraverse().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
            int n = matrix.length * matrix[0].length;
            int[] res = new int[n];
            int index = 0;
            boolean upRight = true;
            int i = 0;
            int j = 0;
            while (index < n) {
                res[index] = matrix[i][j];
                if (upRight) {
                    if (i > 0 && j < matrix[0].length - 1) {
                        i--;
                        j++;
                    } else if (i == 0 && j < matrix[0].length - 1) {
                        j++;
                        upRight = false;
                    } else if (j == matrix[0].length - 1) {
                        i++;
                        upRight = false;
                    }
                } else {
                    if (i < matrix.length - 1 && j > 0) {
                        i++;
                        j--;
                    } else if (j == 0 && i < matrix.length - 1) {
                        i++;
                        upRight = true;
                    } else if (i == matrix.length - 1) {
                        j++;
                        upRight = true;
                    }
                }
                index++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}