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
// 👍 6 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：连通两组点的最小成本
//2020-09-20 16:18:40
public class P5522MinimumCostToConnectTwoGroupsOfPoints {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P5522MinimumCostToConnectTwoGroupsOfPoints().new Solution();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(15);
        list1.add(96);
        list2.add(36);
        list2.add(2);
        lists.add(list1);
        lists.add(list2);
        System.out.println(solution.connectTwoGroups(lists));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int connectTwoGroups(List<List<Integer>> cost) {
            int m = cost.size(), n = cost.get(0).size();
            int[][] costMatrix = new int[m][1 << n];
            for (int k = 0; k < m; k++) {
                for (int i = 0; i < (1 << n); i++) {
                    int sum = 0;
                    for (int j = 0; j < n; j++) {
                        if ((i & (1 << j)) > 0)
                            sum += cost.get(k).get(j);
                    }
                    costMatrix[k][i] = sum;
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 1 << n; j++) {
                    System.out.print(costMatrix[i][j]+"  ");
                }
                System.out.println();
            }
            int[][] dp = new int[m][1 << n];
            for (int i = 1; i < m; i++)
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[0] = costMatrix[0];
            for (int i = 1; i < m; i++)
                for (int j = 1; j < (1 << n); j++)
                    for (int k = 1; k < (1 << n); k++)
                        dp[i][j | k] = Math.min(dp[i][j | k], dp[i - 1][k] + costMatrix[i][j]);
            return dp[m - 1][(1 << n) - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}