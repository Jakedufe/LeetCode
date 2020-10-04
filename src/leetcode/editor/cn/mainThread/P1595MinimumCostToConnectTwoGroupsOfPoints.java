//给你两组点，其中第一组中有 size1 个点，第二组中有 size2 个点，且 size1 >= size2 。 
//
// 任意两点间的连接成本 cost 由大小为 size1 x size2 矩阵给出，其中 cost[i][j] 是第一组中的点 i 和第二组中的点 j 的连接
//成本。如果两个组中的每个点都与另一组中的一个或多个点连接，则称这两组点是连通的。换言之，第一组中的每个点必须至少与第二组中的一个点连接，且第二组中的每个点必须至
//少与第一组中的一个点连接。 
//
// 返回连通两组点所需的最小成本。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：cost = [[15, 96], [36, 2]]
//输出：17
//解释：连通两组点的最佳方法是：
//1--A
//2--B
//总成本为 17 。
// 
//
// 示例 2： 
//
// 
//
// 输入：cost = [[1, 3, 5], [4, 1, 1], [1, 5, 3]]
//输出：4
//解释：连通两组点的最佳方法是：
//1--A
//2--B
//2--C
//3--A
//最小成本为 4 。
//请注意，虽然有多个点连接到第一组中的点 2 和第二组中的点 A ，但由于题目并不限制连接点的数目，所以只需要关心最低总成本。 
//
// 示例 3： 
//
// 输入：cost = [[2, 5, 1], [3, 4, 7], [8, 1, 2], [6, 2, 4], [3, 8, 8]]
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// size1 == cost.length 
// size2 == cost[i].length 
// 1 <= size1, size2 <= 12 
// size1 >= size2 
// 0 <= cost[i][j] <= 100 
// 
// Related Topics 图 动态规划 
// 👍 15 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
//Java：连通两组点的最小成本
//2020-09-21 10:53:58
public class P1595MinimumCostToConnectTwoGroupsOfPoints{
    
    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P1595MinimumCostToConnectTwoGroupsOfPoints().new Solution();        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int connectTwoGroups(List<List<Integer>> cost) {
            int n = cost.get(0).size();
            int m = cost.size();
            int[][] costMatrix = new int[m][1 << n];
            int[][] dp = new int[m][1 << n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 1 << n; j++) {
                    //选择情况为j时，第i行的花费
                    int sum = 0;
                    for (int k = 0; k < n; k++) {
                        if ((j & (1 << k)) > 0) {
                            sum += cost.get(i).get(k);
                        }
                    }
                    costMatrix[i][j] = sum;
                }
            }
            for (int i = 1; i < m; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            dp[0] = costMatrix[0];
            //状态
//            for (int i = 1; i < m; i++) {
//                for (int j = 1; j < 1 << n; j++) {
//                    策略
//                    for (int k = 1; k < 1 << n; k++) {
//                        dp[i][j | k] = Math.min(dp[i][j | k], dp[i - 1][j] + costMatrix[i][k]);
//                    }
//                }
//            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < (1 << n); j++) {
                    for (int k = 0; k < n; k++) {
                        dp[i][j | (1 << k)] = Math.min(dp[i][j | (1 << k)], dp[i - 1][j] + costMatrix[i][1 << k]);
                    }
                    int rest = (1 << n) - 1 - j;
                    for (int k = rest; k > 0; k = rest & (k - 1)) {
                        dp[i][j | k] = Math.min(dp[i][j | k], dp[i - 1][j] + costMatrix[i][k]);
                    }
                }
            }
            return dp[m - 1][(1 << n) - 1];
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}