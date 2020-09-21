//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法 
// 👍 53 👎 0


package leetcode.editor.cn.offerFirstTime;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
//Java：数组中出现次数超过一半的数字
public class P剑指_offer_39ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof{
    
    @Test
    public void testResult() {
        Solution solution = new P剑指_offer_39ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof().new Solution();      // TO TEST
        solution.majorityElement(new int[]{1,2,3,2,2,2,5,4,2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])){
                Integer times = hashMap.get(nums[i]);
                hashMap.put(nums[i],times+1);
            }else {
                hashMap.put(nums[i],1);
            }
        }
        for (Integer integer : hashMap.keySet()) {
            if (hashMap.get(integer) > nums.length/2){
                return integer;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}