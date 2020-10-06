//给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。 
//
// 第 i 条边连接节点 edges[i][0] 和 edges[i][1] 。 
//
// 返回一个表示节点 i 与其他所有节点距离之和的列表 ans。 
//
// 示例 1: 
//
// 
//输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
//输出: [8,12,6,10,10,10]
//解释: 
//如下为给定的树的示意图：
//  0
// / \
//1   2
//   /|\
//  3 4 5
//
//我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5) 
//也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
// 
//
// 说明: 1 <= N <= 10000 
// Related Topics 树 深度优先搜索 
// 👍 122 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//Java：树中距离之和
//2020-10-06 10:18:49
public class P834SumOfDistancesInTree {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P834SumOfDistancesInTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] ans;
        int[] sz;
        int[] dp;
        List<List<Integer>> graph;

        public int[] sumOfDistancesInTree(int N, int[][] edges) {
            ans = new int[N];
            sz = new int[N];
            dp = new int[N];
            graph = new ArrayList<List<Integer>>();
            for (int i = 0; i < N; ++i) {
                graph.add(new ArrayList<Integer>());
            }
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            dfs(0, -1);
            dfs2(0, -1);
            return ans;
        }

        public void dfs(int u, int f) {
            sz[u] = 1;
            dp[u] = 0;
            for (int v : graph.get(u)) {
                if (v == f) {
                    continue;
                }
                dfs(v, u);
                dp[u] += dp[v] + sz[v];
                sz[u] += sz[v];
            }
        }

        public void dfs2(int u, int f) {
            ans[u] = dp[u];
            for (int v : graph.get(u)) {
                if (v == f) {
                    continue;
                }
                int pu = dp[u], pv = dp[v];
                int su = sz[u], sv = sz[v];

                dp[u] -= dp[v] + sz[v];
                sz[u] -= sz[v];
                dp[v] += dp[u] + sz[u];
                sz[v] += sz[u];

                dfs2(v, u);

                dp[u] = pu;
                dp[v] = pv;
                sz[u] = su;
                sz[v] = sv;
            }
        }


//        /**
//         * 内存超限
//         *
//         * @param N
//         * @param edges
//         * @return
//         */
//        public int[] sumOfDistancesInTree(int N, int[][] edges) {
//            int[][] dist = new int[N][N];
//            for (int i = 0; i < edges.length; i++) {
//                int u = edges[i][0];
//                int v = edges[i][1];
//                dist[u][v] = 1;
//                dist[v][u] = 1;
//            }
//            Deque<Integer> deque = new LinkedList<>();
//            boolean[] visited = new boolean[N];
//            for (int i = 0; i < N; i++) {
//                deque.clear();
//                Arrays.fill(visited, false);
//                visited[i] = true;
//                for (int j = 0; j < N; j++) {
//                    if (i == j) continue;
//                    if (dist[i][j] == 1) {
//                        deque.offerLast(j);
//                        visited[j] = true;
//                    }
//                }
//                int level = 2;
//                while (!deque.isEmpty()) {
//                    int size = deque.size();
//                    for (int j = 0; j < size; j++) {
//                        Integer poll = deque.pollFirst();
//                        for (int k = 0; k < N; k++) {
//                            if (visited[k]) continue;
//                            if (dist[poll][k] == 1) {
//                                if (dist[i][k] == 0) {
//                                    dist[i][k] = level;
//                                }
//                                visited[k] = true;
//                                deque.offerLast(k);
//                            }
//                        }
//                    }
//                    level++;
//                }
//            }
//
//            int[] ans = new int[N];
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    ans[i] += dist[i][j];
//                }
//            }
//            return ans;
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}