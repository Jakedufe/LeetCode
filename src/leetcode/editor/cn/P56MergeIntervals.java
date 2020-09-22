//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 618 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：合并区间
//2020-09-22 10:29:49
public class P56MergeIntervals {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P56MergeIntervals().new Solution();
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 前缀数组解法，无法解决以下情况
         * 解答失败:
         * 测试用例:[[1,4],[5,6]]
         * 测试结果:[[1,6]]
         * 期望结果:[[1,4],[5,6]]
         *
         * @param intervals
         * @return
         */
        public int[][] merge(int[][] intervals) {
            int maxIndex = 0;
            for (int i = 0; i < intervals.length; i++) {
                if (intervals[i][1] > maxIndex) maxIndex = intervals[i][1];
            }
            maxIndex++;
            maxIndex++;
            int[] diff = new int[maxIndex];
            for (int i = 0; i < intervals.length; i++) {
                diff[intervals[i][0]]++;
                diff[intervals[i][1] + 1]--;
            }
            for (int i = 0; i < maxIndex - 1; i++) {
                diff[i + 1] += diff[i];
            }
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < maxIndex; i++) {
                if (diff[i] > 0) {
                    int start = i;
                    while (i < maxIndex && diff[i] > 0) {
                        i++;
                    }
                    int[] ints = {start, i - 1};
                    list.add(ints);
                }
            }
            int[][] result = new int[list.size()][2];
            int i = 0;
            for (int[] ints : list) {
                result[i++] = ints;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}