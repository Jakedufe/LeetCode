//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 149 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//Java：和为s的连续正数序列
//2020-09-08 15:33:05
public class P剑指_offer_57__i_iHeWeiSdeLianXuZhengShuXuLieLcof {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P剑指_offer_57__i_iHeWeiSdeLianXuZhengShuXuLieLcof().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int[][] findContinuousSequence(int target) {
            List<List<Integer>> lists = new ArrayList<>();
            int l = 1;
            int r = 1;
            int tmp = 1;

            while (r < target / 2 + 2) {
                while (tmp < target) {
                    r++;
                    tmp += r;
                    if (tmp == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(l);
                        list.add(r);
                        lists.add(list);
                    }
                }
                while (target - tmp < r) {
                    tmp -= l;
                    l++;
                    if (tmp == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(l);
                        list.add(r);
                        lists.add(list);
                    }
                }
            }
            int[][] re = new int[lists.size()][];
            int index = 0;
            for (List<Integer> list : lists) {
                int a = list.get(0);
                int b = list.get(1);
                int[] arr = new int[b - a + 1];
                for (int i = 0; i < b - a + 1; i++) {
                    arr[i] = a + i;
                }
                re[index] = arr;
                index++;
            }
            return re;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}