//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// 👍 72 👎 0


package leetcode.editor.cn.offerFirstTime;

import org.junit.Test;

//Java：数组中数字出现的次数 II
//2020-09-07 17:42:48
public class P剑指_offer_56__i_iShuZuZhongShuZiChuXianDeCiShuIiLcof{

@Test
public void testResult(){
        //TO TEST
        Solution solution=new P剑指_offer_56__i_iShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        //统计二进制数各个位数的1的个数
        int[] count = new int[32];
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                count[j] += copy[i] & 1;
                copy[i] >>>= 1;
            }
        }
        for (int i = 0; i < 32; i++) {
            count[i] %= 3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            stringBuilder.append(count[i]);
        }
        int re = 0;
        for (int i = 31; i >= 0; i--) {
            re = re << 1;
            re |= count[i];
        }
        return re;

//        Map<Integer, Integer> hashMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (hashMap.containsKey(nums[i])) {
//                Integer times = hashMap.get(nums[i]);
//                hashMap.put(nums[i], times + 1);
//            } else {
//                hashMap.put(nums[i], 1);
//            }
//        }
//        for (Integer value : hashMap.keySet()) {
//            if (hashMap.get(value) == 1) return value;
//        }
//        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}