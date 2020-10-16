//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。 
//
// 
//
// 示例 1： 
//
// 输入：[-4,-1,0,3,10]
//输出：[0,1,9,16,100]
// 
//
// 示例 2： 
//
// 输入：[-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// -10000 <= A[i] <= 10000 
// A 已按非递减顺序排序。 
// 
// Related Topics 数组 双指针 
// 👍 141 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：有序数组的平方
//2020-10-16 09:55:48
public class P977SquaresOfASortedArray {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P977SquaresOfASortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] A) {
            int n = A.length;
            int[] re = new int[n];
            int i = 0;
            int j = n - 1;
            int pos = n - 1;
            while (i <= j) {
                if (A[i] * A[i] > A[j] * A[j]) {
                    re[pos--] = A[i] * A[i];
                    i++;
                } else {
                    re[pos--] = A[j] * A[j];
                    j--;
                }
            }
            return re;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}