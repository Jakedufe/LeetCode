//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针 
// 👍 644 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：颜色分类
//2020-10-07 18:57:11
public class P75SortColors {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P75SortColors().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int n = nums.length;
            int l = 0;
            int r = n - 1;
            while (l < r) {
                while (l < r && nums[l] == 0) l++;
                if (l >= r) break;
                while (l < r && nums[r] != 0) r--;
                if (l >= r) break;
                nums[r] = nums[l];
                nums[l] = 0;
            }
            r = n - 1;
            while (l < r) {
                while (l < r && nums[l] == 1) l++;
                if (l >= r) break;
                while (l < r && nums[r] != 1) r--;
                if (l >= r) break;
                nums[l] = 1;
                nums[r] = 2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}