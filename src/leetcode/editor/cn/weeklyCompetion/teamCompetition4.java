package leetcode.editor.cn.weeklyCompetion;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Java：周赛
//2020-09-19 15:09:18
public class teamCompetition4 {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new teamCompetition4().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumRequests(int n, int[][] requests) {
            Map<Integer, Integer> hashMap = new HashMap<>();
            Arrays.sort(requests);
            int index = 0;
            for (int i = 0; i < requests.length; i++) {
                if (requests[i][0] == index) {
                    hashMap.put(index++, i);
                }
            }
            int start = 0;
            int res = 0;
            boolean[] visited = new boolean[requests.length];

            for (int i = 0; i < requests.length; i++) {
                start = requests[i][0];
                int last = requests[i][1];
                int count = 0;
                while (last != start) {
                    Integer pos = hashMap.get(last);
                    count++;
                    for (int j = pos; j < hashMap.get(last + 1); j++) {
                        if (!visited[j]) {
                            last = requests[j][1];
                            visited[i] = true;
                            break;
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}