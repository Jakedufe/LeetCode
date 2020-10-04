//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 你可以假设数组中不存在重复元素。 
//
// 示例 1: 
//
// 输入: [3,4,5,1,2]
//输出: 1 
//
// 示例 2: 
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0 
// Related Topics 数组 二分查找 
// 👍 259 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

//Java：寻找旋转排序数组中的最小值
//2020-09-23 10:27:41
public class P153FindMinimumInRotatedSortedArray {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P153FindMinimumInRotatedSortedArray().new Solution();
        System.out.println(solution.findMin(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (nums[mid] > nums[0] && nums[mid] > nums[r]) {
                    l = mid + 1;
                } else if (nums[mid] > nums[0]) {
                    r = mid - 1;
                } else if (nums[mid] < nums[0]) {
                    r = mid;
                } else break;
            }
            return Math.min(nums[l], nums[r]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}