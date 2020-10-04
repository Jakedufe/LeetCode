//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
// Related Topics 数组 
// 👍 15 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

import java.util.Arrays;

//Java：零矩阵
//2020-09-22 13:27:04
public class P面试题_0108ZeroMatrixLcci {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P面试题_0108ZeroMatrixLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            boolean[] r = new boolean[matrix.length];
            boolean[] c = new boolean[matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        r[i] = true;
                        c[j] = true;
                    }
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                if (r[i]) {
                    Arrays.fill(matrix[i], 0);
                }
            }
            for (int i = 0; i < matrix[0].length; i++) {
                if (c[i]) {
                    for (int j = 0; j < matrix.length; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}