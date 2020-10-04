//给定一个整数数组 A，返回 A 中最长等差子序列的长度。 
//
// 回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中 0 <= i_1 < i_2 < ... < i_k <= A
//.length - 1。并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，那么序列 B 是等差的。 
//
// 
//
// 示例 1： 
//
// 输入：[3,6,9,12]
//输出：4
//解释： 
//整个数组是公差为 3 的等差数列。
// 
//
// 示例 2： 
//
// 输入：[9,4,7,2,10]
//输出：3
//解释：
//最长的等差子序列是 [4,7,10]。
// 
//
// 示例 3： 
//
// 输入：[20,1,15,3,10,5,8]
//输出：4
//解释：
//最长的等差子序列是 [20,15,10,5]。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 2000 
// 0 <= A[i] <= 10000 
// 
// Related Topics 动态规划 
// 👍 80 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//Java：最长等差数列
//2020-10-03 20:00:51
public class P1027LongestArithmeticSubsequence {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P1027LongestArithmeticSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestArithSeqLength(int[] A) {
            int n = A.length;
            int ans = 0;
            int[][] dp = new int[n][n];
            Map<Integer, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    Integer index = indexMap.getOrDefault(2 * A[i] - A[j], -1);
                    if (index >= 0 && index < i) {
                        dp[i][j] = Math.max(dp[i][j], dp[index][i] + 1);
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
                indexMap.put(A[i], i);
            }
            return ans + 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}