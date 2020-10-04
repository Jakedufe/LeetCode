//给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。 
//
// 
//
// 示例： 
//
// 输入：A = [4,5,0,-2,-3,1], K = 5
//输出：7
//解释：
//有 7 个子数组满足其元素之和可被 K = 5 整除：
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 30000 
// -10000 <= A[i] <= 10000 
// 2 <= K <= 10000 
// 
// Related Topics 数组 哈希表 
// 👍 200 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

//Java：和可被 K 整除的子数组
//2020-09-21 16:19:12
public class P974SubarraySumsDivisibleByK {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P974SubarraySumsDivisibleByK().new Solution();
        System.out.println(solution.subarraysDivByK(new int[]{-8, 1, 4, 1}, 10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraysDivByK(int[] A, int K) {
            int n = A.length;
            int sum = 0;
            int total = 0;
            int[] hash = new int[K];
            hash[0] = 1;
            for (int i = 0; i < n; i++) {
                sum += A[i];
                sum = (sum % K + K) % K;
                int curMod = sum % K;
                total += hash[curMod];
                hash[curMod]++;
            }
            return total;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}