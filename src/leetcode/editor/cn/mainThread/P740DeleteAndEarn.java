//给定一个整数数组 nums ，你可以对它进行一些操作。 
//
// 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] +
// 1 的元素。 
//
// 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。 
//
// 示例 1: 
//
// 
//输入: nums = [3, 4, 2]
//输出: 6
//解释: 
//删除 4 来获得 4 个点数，因此 3 也被删除。
//之后，删除 2 来获得 2 个点数。总共获得 6 个点数。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2, 2, 3, 3, 3, 4]
//输出: 9
//解释: 
//删除 3 来获得 3 个点数，接着要删除两个 2 和 4 。
//之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
//总共获得 9 个点数。
// 
//
// 注意: 
//
// 
// nums的长度最大为20000。 
// 每个整数nums[i]的大小都在[1, 10000]范围内。 
// 
// Related Topics 动态规划 
// 👍 188 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

//Java：删除与获得点数
//2020-10-02 21:32:04
public class P740DeleteAndEarn {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P740DeleteAndEarn().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * hash数组
         *
         * @param nums
         * @return
         */
        public int deleteAndEarn(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            int maxN = 0;
            for (int i = 0; i < n; i++) {
                maxN = Math.max(maxN, nums[i]);
            }
            int size = maxN + 1;
            int[] hash = new int[size];
            for (int i = 0; i < n; i++) {
                hash[nums[i]]++;
            }
            int[] dp = new int[size];
            dp[1] = hash[1];
            for (int i = 2; i < size; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + hash[i] * i);
            }
            return dp[size - 1];
        }

//        /**
//         * 自己写的又臭又长的代码
//         * @param nums
//         * @return
//         */
//        public int deleteAndEarn(int[] nums) {
//            int n = nums.length;
//            Map<Integer, Integer> hashMap = new HashMap<>();
//            for (int i = 0; i < n; i++) {
//                if (hashMap.containsKey(nums[i])) {
//                    Integer times = hashMap.get(nums[i]);
//                    hashMap.put(nums[i], times + 1);
//                } else {
//                    hashMap.put(nums[i], 1);
//                }
//            }
//            int size = hashMap.size();
//            Integer[] arr = new Integer[size];
//            int index = 0;
//            for (Integer integer : hashMap.keySet()) {
//                arr[index++] = integer;
//            }
//            Arrays.sort(arr, (o1, o2) -> o2 - o1);
//            if (size == 0) return 0;
//            int[] dp = new int[size];
//            dp[0] = arr[0] * hashMap.get(arr[0]);
//            if (size == 1) return dp[0];
//            if (arr[0] - 1 != arr[1]) {
//                dp[1] = dp[0] + arr[1] * hashMap.get(arr[1]);
//            } else {
//                dp[1] = Math.max(dp[0], arr[1] * hashMap.get(arr[1]));
//            }
//            if (size == 2) return dp[1];
//            for (int i = 2; i < size; i++) {
//                if (arr[i] != arr[i - 1] - 1) {
//                    dp[i] = arr[i] * hashMap.get(arr[i]) + Math.max(dp[i - 1], dp[i - 2]);
//                } else {
//                    dp[i] = Math.max(arr[i] * hashMap.get(arr[i]) + dp[i - 2], dp[i - 1]);
//                }
//            }
//            return dp[size - 1];
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}