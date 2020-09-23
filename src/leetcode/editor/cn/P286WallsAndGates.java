//你被给定一个 m × n 的二维网格，网格中有以下三种可能的初始化值： 
//
// 
// -1 表示墙或是障碍物 
// 0 表示一扇门 
// INF 无限表示一个空的房间。然后，我们用 231 - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 
//的。 
// 
//
// 你要给每个空房间位上填上该房间到 最近 门的距离，如果无法到达门，则填 INF 即可。 
//
// 示例： 
//
// 给定二维网格： 
//
// INF  -1  0  INF
//INF INF INF  -1
//INF  -1 INF  -1
//  0  -1 INF INF
// 
//
// 运行完你的函数后，该网格应该变成： 
//
//   3  -1   0   1
//  2   2   1  -1
//  1  -1   2  -1
//  0  -1   3   4
// 
// Related Topics 广度优先搜索 
// 👍 88 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

//Java：墙与门
//2020-09-23 21:16:48
public class P286WallsAndGates {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P286WallsAndGates().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void wallsAndGates(int[][] rooms) {
            if (rooms.length == 0 || rooms[0].length == 0) return;
            Deque<int[]> queue = new LinkedList<>();
            for (int i = 0; i < rooms.length; i++) {
                for (int j = 0; j < rooms[0].length; j++) {
                    if (rooms[i][j] == 0) queue.offer(new int[]{i, j});
                }
            }
            int[][] moves = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
            int index = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    for (int[] move : moves) {
                        int r = poll[0] + move[0];
                        int c = poll[1] + move[1];
                        if (inArea(r, c, rooms) && rooms[r][c] > index) {
                            rooms[r][c] = index;
                            queue.offer(new int[]{r, c});
                        }
                    }
                }
                index++;
            }
        }

        private boolean inArea(int r, int c, int[][] rooms) {
            return r < rooms.length && r >= 0 && c < rooms[0].length && c >= 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}