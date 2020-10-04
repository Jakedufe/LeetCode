package leetcode.editor.cn.weeklyCompetion.D36;

import org.junit.Test;

import java.util.*;

//Java：周赛
//2020-09-19 15:09:18
public class Competition4 {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new Competition4().new Solution();
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{5, 2, 3, 3, 3};
        System.out.println(solution.busiestServers(3, a, b));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Server implements Comparable<Server> {
            int cnt;
            int no;
            int finishTime;

            Server(int no) {
                cnt = 0;
                finishTime = 0;
                this.no = no;
            }

            void use(int curTime, int load) {
                cnt++;
                finishTime = curTime + load;
            }

            boolean getStatus(int curTime) {
                if (curTime < finishTime) return false;
                else return true;
            }

            @Override
            public int compareTo(Server o) {
                return this.no - o.no;
            }
        }

        public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
            List<Server> serverList = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                serverList.add(new Server(i));
            }
            TreeSet<Server> treeSet = new TreeSet<>();
            TreeMap<Integer, List<Server>> treeMap = new TreeMap<>();
            List<Server> list = new ArrayList<>(serverList);
            treeMap.put(0, list);
            int n = arrival.length;

            for (int i = 0; i < n; i++) {
                int index = i % k;
                int curTime = arrival[i];
                SortedMap<Integer, List<Server>> subMap = treeMap.subMap(0, curTime + 1);
                Iterator<Integer> iterator = subMap.keySet().iterator();
                while (iterator.hasNext()) {
                    Integer key = iterator.next();
                    List<Server> servers = subMap.get(key);
                    treeSet.addAll(servers);
                    iterator.remove();
                }
                if (treeSet.size() == 0) continue;
                Server s = serverList.get(index);
                Server server = treeSet.ceiling(s);
                if (server == null) server = treeSet.first();
                server.use(curTime, load[i]);
                treeSet.remove(server);
                if (!treeMap.containsKey(server.finishTime)) {
                    treeMap.put(server.finishTime, new ArrayList<>());
                }
                treeMap.get(server.finishTime).add(server);
            }
            int max = 0;
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                int cnt = serverList.get(i).cnt;
                if (cnt == max) {
                    res.add(i);
                } else if (cnt > max) {
                    max = cnt;
                    res.clear();
                    res.add(i);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}