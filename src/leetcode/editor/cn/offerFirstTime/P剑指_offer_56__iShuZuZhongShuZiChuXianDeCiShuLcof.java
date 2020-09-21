//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// 👍 213 👎 0


package leetcode.editor.cn.offerFirstTime;

import org.junit.Test;

//Java：数组中数字出现的次数
//2020-09-07 16:29:56
public class P剑指_offer_56__iShuZuZhongShuZiChuXianDeCiShuLcof{

@Test
public void testResult(){
        //TO TEST
        Solution solution=new P剑指_offer_56__iShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumbers(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp ^= nums[i];
        }
        int div = tmp & (-tmp);
//        while ((tmp & div) == 0) {
//            div = div << 1;
//        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & div) == 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        int[] re = new int[2];
        re[0] = a;
        re[1] = b;
        return re;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}