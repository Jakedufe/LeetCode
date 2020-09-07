//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
// Related Topics 数组 二分查找 
// 👍 61 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：0～n-1中缺失的数字
public class P剑指_offer_53__i_iQueShiDeShuZiLcof{

@Test
public void testResult(){
        //TO TEST
        Solution solution=new P剑指_offer_53__i_iQueShiDeShuZiLcof().new Solution();
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int re;
    int n;

    public int missingNumber(int[] nums) {
        n = nums.length + 1;
        if (nums.length < 50) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }
            return nums.length;
        } else
            bSearch(nums, 0, n);
        return re;
    }

    private void bSearch(int[] nums, int l, int r) {
        if (l > r) return;
        int mid = (l + r) / 2;
        if (mid == n) {
            re = n;
            return;
        } else if (nums[mid] == mid) {
            bSearch(nums, mid + 1, r);
        } else if (nums[mid] > mid) {
            if (mid > 0 && nums[mid] - nums[mid - 1] == 2) {
                re = mid;
                return;
            } else
                bSearch(nums, l, mid - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}