//有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。 
//
// 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 
//N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。 
//
// 最初，除 0 号房间外的其余所有房间都被锁住。 
//
// 你可以自由地在房间之间来回走动。 
//
// 如果能进入每个房间返回 true，否则返回 false。 
//
// 
// 
//
// 示例 1： 
//
// 输入: [[1],[2],[3],[]]
//输出: true
//解释:  
//我们从 0 号房间开始，拿到钥匙 1。
//之后我们去 1 号房间，拿到钥匙 2。
//然后我们去 2 号房间，拿到钥匙 3。
//最后我们去了 3 号房间。
//由于我们能够进入每个房间，我们返回 true。
// 
//
// 示例 2： 
//
// 输入：[[1,3],[3,0,1],[2],[0]]
//输出：false
//解释：我们不能进入 2 号房间。
// 
//
// 提示： 
//
// 
// 1 <= rooms.length <= 1000 
// 0 <= rooms[i].length <= 1000 
// 所有房间中的钥匙数量总计不超过 3000。 
// 
// Related Topics 深度优先搜索 图 
// 👍 152 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Java：钥匙和房间
//2020-09-24 21:03:40
public class P841KeysAndRooms {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P841KeysAndRooms().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            Deque<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[rooms.size()];
            visited[0] = true;
            for (Integer room : rooms.get(0)) {
                if (!visited[room]) {
                    visited[room] = true;
                    queue.offer(room);
                }
            }
            while (!queue.isEmpty()) {
                for (Integer room : rooms.get(queue.poll())) {
                    if (!visited[room]) {
                        visited[room] = true;
                        queue.offer(room);
                    }
                }
            }
            for (boolean b : visited) {
                if (!b) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}