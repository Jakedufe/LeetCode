//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 62 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

//Java：在排序数组中查找数字 I
public class P剑指_offer_53__iZaiPaiXuShuZuZhongChaZhaoShuZiLcof {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P剑指_offer_53__iZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        System.out.println(solution.search(new int[]{5, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 10}, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int index = Arrays.binarySearch(nums, target);
            System.out.println(index);
            if (index < 0) return 0;
            int l = index;
            int r = index + 1;
            int count = 0;
            while (l >= 0 && nums[l--] == target) count++;
            while (r < nums.length && nums[r++] == target) count++;
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}