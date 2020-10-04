package leetcode.editor.cn.weeklyCompetion.D36;

import org.junit.Test;

import java.util.*;


//Java：周赛
//2020-09-19 15:09:18
public class Competition2 {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new Competition2().new Solution();
        String[] a = {"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] b = {"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
        System.out.println(solution.alertNames(a, b));


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> alertNames(String[] keyName, String[] keyTime) {
            Map<String, List<String>> map = new HashMap<>();
            Set<String> res = new HashSet<>();
            int n = keyName.length;
            for (int i = 0; i < n; i++) {
                if (map.containsKey(keyName[i])) {
                    List<String> list = map.get(keyName[i]);
                    list.add(keyTime[i]);
                    map.put(keyName[i], list);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(keyTime[i]);
                    map.put(keyName[i], list);
                }
            }
            for (String s : map.keySet()) {
                List<String> list = map.get(s);
                list.sort(String::compareTo);
                for (int i = 2; i < list.size(); i++) {
                    int a = getInt(list.get(i));
                    int b = getInt(list.get(i - 2));
                    if (a - b <= 60) {
                        res.add(s);
                    }
                }
            }
            List<String> ans = new ArrayList<>(res);
            ans.sort(String::compareTo);
            return ans;
        }

        private int getInt(String s) {
            String[] split = s.split(":");
            int h = Integer.parseInt(split[0]);
            int mi = Integer.parseInt(split[1]);
            return h * 60 + mi;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}