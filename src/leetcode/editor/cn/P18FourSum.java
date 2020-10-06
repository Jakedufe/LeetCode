//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 617 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

//Java：四数之和
//2020-10-05 18:08:26
public class P18FourSum {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P18FourSum().new Solution();
        System.out.println(solution.fourSum(new int[]{-3, -1, 0, 2, 4, 5}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> lists = new ArrayList<>();
            if (n <= 3) return lists;
            Set<String> set = new HashSet<>();
            HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (!hashMap.containsKey(nums[i])) {
                    hashMap.put(nums[i], new ArrayList<>());
                }
                hashMap.get(nums[i]).add(i);
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int tar = target - nums[i] - nums[j];
                    for (int k = j + 1; k < n; k++) {
                        int hashKey = tar - nums[k];
                        if (hashMap.containsKey(hashKey)) {
                            List<Integer> list = hashMap.get(hashKey);
                            int l = -1;
                            for (Integer integer : list) {
                                if (integer != i && integer != j && integer != k) l = integer;
                            }
                            if (l >= 0) {
                                int[] ans = new int[]{nums[i], nums[j], nums[k], nums[l]};
                                Arrays.sort(ans);
                                String s = "" + ans[0] + " " + ans[1] + " " + ans[2] + " " + ans[3];
                                if (!set.contains(s)) {
                                    List<Integer> list1 = new ArrayList<>();
                                    for (int an : ans) {
                                        list1.add(an);
                                    }
                                    lists.add(list1);
                                    set.add(s);
                                }

                            }
                        }
                    }
                }
            }
            return lists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}