//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
// 👍 41 👎 0


package leetcode.editor.cn.offerFirstTime;

import org.junit.Test;

import java.util.Arrays;

//Java：和为s的两个数字
//2020-09-08 15:10:44
public class P剑指_offer_57HeWeiSdeLiangGeShuZiLcof {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P剑指_offer_57HeWeiSdeLiangGeShuZiLcof().new Solution();
        int[] ints = solution.twoSum(new int[]{16, 16, 18, 24, 30, 32}, 48);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int l = 0;
            int r = Arrays.binarySearch(nums, target);
            if (r < 0) r = -r;
            while (r >= nums.length) r--;
            while (l < r && r < nums.length) {
                if (nums[l] + nums[r] > target) {
                    r--;
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    return new int[]{nums[l], nums[r]};
                }
            }
            return new int[]{0, 0};
        }
//        public int[] twoSum(int[] nums, int target) {
//            for (int i = 0; i < nums.length && target >= nums[i] * 2; i++) {
//                int index = Arrays.binarySearch(nums, target - nums[i]);
//                if (index > 0 && index != i) return new int[]{nums[i], nums[index]};
//            }
//            return new int[]{0, 0};
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}