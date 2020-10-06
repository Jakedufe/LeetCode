//给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。 
//
//
// 如果有多个目标子集，返回其中任何一个均可。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2] (当然, [1,3] 也正确)
// 
//
// 示例 2: 
//
// 输入: [1,2,4,8]
//输出: [1,2,4,8]
// 
// Related Topics 数学 动态规划 
// 👍 148 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：最大整除子集
//2020-10-04 21:53:14
public class P368LargestDivisibleSubset {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P368LargestDivisibleSubset().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            int n = nums.length;
            List<Integer> res = new ArrayList<>();
            if (n == 0) return res;
            List<List<Integer>> dp = new ArrayList<>();
            for (int num : nums) {
                dp.add(new ArrayList<>());
            }
            Arrays.sort(nums);
            dp.get(0).add(nums[0]);
            for (int i = 1; i < n; i++) {
                List<Integer> maxSet = dp.get(i);
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0 && maxSet.size() < dp.get(j).size()) maxSet = dp.get(j);
                }
                dp.get(i).addAll(maxSet);
                dp.get(i).add(nums[i]);
            }
            for (List<Integer> list : dp) {
                if (list.size() > res.size()) res = list;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}