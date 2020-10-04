//给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。 
//
// 不占用额外内存空间能否做到？ 
//
// 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组 
// 👍 122 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

//Java：旋转矩阵
//2020-09-22 12:06:33
public class P面试题_0107RotateMatrixLcci {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P面试题_0107RotateMatrixLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[matrix.length - 1 - i][j];
                    matrix[matrix.length - 1 - i][j] = tmp;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < i; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}