//给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如
//同俄罗斯套娃一样。 
//
// 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 说明: 
//不允许旋转信封。 
//
// 示例: 
//
// 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出: 3 
//解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
// 
// Related Topics 二分查找 动态规划 
// 👍 212 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

import java.util.Arrays;

//Java：俄罗斯套娃信封问题
//2020-10-01 19:07:01
public class P354RussianDollEnvelopes {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P354RussianDollEnvelopes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            });
            int[] arr = new int[envelopes.length];
            for (int i = 0; i < envelopes.length; i++) {
                arr[i] = envelopes[i][1];
            }
            return lengthOfLIS(arr);
        }

        private int lengthOfLIS(int[] nums) {
            if (nums.length == 0) return 0;
            int[] arr = new int[nums.length];
            int index = 0;
            arr[index] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > arr[index]) {
                    arr[++index] = nums[i];
                } else {
                    int pos = Arrays.binarySearch(arr, 0, index + 1, nums[i]);
                    if (pos < 0) arr[-pos - 1] = nums[i];
                }
            }
            return index + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}