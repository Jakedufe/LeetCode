//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// 👍 228 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：数组中的逆序对
public class P剑指_offer_51ShuZuZhongDeNiXuDuiLcof {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P剑指_offer_51ShuZuZhongDeNiXuDuiLcof().new Solution();
        System.out.println(solution.reversePairs(new int[]{7, 5, 6, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reversePairs(int[] nums) {
            int n = nums.length;
            int total = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int tmp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = tmp;
                        total++;
                    }
                }
            }
            return total;
        }


//        public int reversePairs(int[] nums) {
//            List<Integer> list = new LinkedList<>();
//            int last = 0;
//            int cur = 0;
//            for (int i = 0; i < nums.length; i++) {
//                int a = nums[i];
//                list.add(a);
//                Collections.sort(list);
//                int pos = Collections.binarySearch(list, a);
//                while (pos < list.size() && list.get(pos) == a) pos++;
//                int bigNum = list.size() - pos;
//                cur = last + bigNum;
//                last = cur;
//            }
//            return cur;
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}