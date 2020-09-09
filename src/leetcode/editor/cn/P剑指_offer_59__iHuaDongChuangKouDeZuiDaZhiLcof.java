//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 109 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：滑动窗口的最大值
//2020-09-08 16:38:57
public class P剑指_offer_59__iHuaDongChuangKouDeZuiDaZhiLcof{

@Test
public void testResult(){
        //TO TEST
        Solution solution=new P剑指_offer_59__iHuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int[] re = new int[nums.length - k + 1];
        int index = 0;
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < k; l++) {
            if (nums[l] > max) {
                index = l;
                max = nums[l];
            }
        }
        re[0] = max;
        for (int i = 1, j = k + 1; i < nums.length - k + 1; i++) {
            if (nums[j - 1] <= max && index >= i) {
                re[i] = max;
                j++;
                continue;
            }
            if (i > index) max = Integer.MIN_VALUE;
            for (int l = Math.max(index, i); l < j; l++) {
                if (nums[l] > max) {
                    index = l;
                    max = nums[l];
                }
            }
            re[i] = max;
            j++;
        }
        return re;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}