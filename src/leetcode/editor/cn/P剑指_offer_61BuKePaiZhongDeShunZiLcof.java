//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// 👍 62 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：扑克牌中的顺子
//2020-09-12 17:26:49
public class P剑指_offer_61BuKePaiZhongDeShunZiLcof {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P剑指_offer_61BuKePaiZhongDeShunZiLcof().new Solution();
        System.out.println(solution.isStraight(new int[]{11,10,0,0,12}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStraight(int[] nums) {
            boolean[] hash = new boolean[14];
            boolean flag = false;
            int king = 0;
            int kingCopy;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) king++;
                else hash[nums[i]] = true;
            }
            kingCopy = king;
            for (int i = 1; i < 10; i++) {
                if (hash[i]) {
                    int j = i + 1;
                    for (; j < 14 && j < i + 5; j++) {
                        if (hash[j]) {
                            continue;
                        }
                        if (!hash[j] && king > 0)
                            king--;
                        else if (!hash[j]) {
                           break;
                        }
                    }
                    if (j == i + 5) flag = true;
                    break;
                }
            }
            king = kingCopy;
            for (int i = 13; i >4; i--) {
                if (hash[i]) {
                    int j = i - 1;
                    for (; j >0 && j > i - 5; j--) {
                        if (hash[j]) {
                            continue;
                        }
                        if (!hash[j] && king > 0)
                            king--;
                        else if (!hash[j]) {
                            break;
                        }
                    }
                    if (j == i - 5) flag = true;
                    break;
                }
            }
            return flag;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}