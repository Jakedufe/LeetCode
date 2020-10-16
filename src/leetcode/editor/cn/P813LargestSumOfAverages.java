//我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。计算我们所能得到的最大分数是多少。 
//
// 注意我们必须使用 A 数组中的每一个数进行分组，并且分数不一定需要是整数。 
//
// 
//示例:
//输入: 
//A = [9,1,2,3,9]
//K = 3
//输出: 20
//解释: 
//A 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
//我们也可以把 A 分成[9, 1], [2], [3, 9].
//这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
// 
//
// 说明: 
//
// 
// 1 <= A.length <= 100. 
// 1 <= A[i] <= 10000. 
// 1 <= K <= A.length. 
// 答案误差在 10^-6 内被视为是正确的。 
// 
// Related Topics 动态规划 
// 👍 124 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：最大平均值和的分组
//2020-10-16 12:07:22
public class P813LargestSumOfAverages {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P813LargestSumOfAverages().new Solution();
        int[] arr = new int[]{9, 1, 2, 3, 9};
        System.out.println(solution.largestSumOfAverages(arr, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double largestSumOfAverages(int[] A, int K) {
            int n = A.length;
            double[] dp = new double[n];
            int[] pre_Sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                pre_Sum[i + 1] = pre_Sum[i] + A[i];
            }
            for (int i = 0; i < n; i++) {
                dp[i] = (pre_Sum[n] - pre_Sum[i]) * 1.0 / (n - i);
            }
            for (int k = 0; k < K - 1; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n - k; j++) {
                        dp[i] = Math.max(dp[i], dp[j] + (pre_Sum[j] - pre_Sum[i]) * 1.0 / (j - i));
                    }
                }
            }
            return dp[0];
        }

//        public double largestSumOfAverages(int[] A, int K) {
//            int n = A.length;
//            double[][] dp = new double[n][K];
//            int[] pre_Sum = new int[n + 1];
//            for (int i = 0; i < n; i++) {
//                pre_Sum[i + 1] = pre_Sum[i] + A[i];
//            }
//            for (int i = 0; i < n; i++) {
//                dp[i][0] = pre_Sum[i + 1] * 1.0 / (i + 1);
//            }
//            for (int k = 1; k < K; k++) {
//                for (int i = k; i < n; i++) {
//                    for (int j = k - 1; j < i; j++) {
//                        dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + (pre_Sum[i + 1] - pre_Sum[j + 1]) * 1.0 / (i - j));
//                    }
//                }
//            }
//            return dp[n - 1][K - 1];
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}