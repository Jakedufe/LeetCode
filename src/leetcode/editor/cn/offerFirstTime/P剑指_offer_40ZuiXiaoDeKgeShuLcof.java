//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 121 👎 0


package leetcode.editor.cn.offerFirstTime;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
//Java：最小的k个数
public class P剑指_offer_40ZuiXiaoDeKgeShuLcof{
    
    @Test
    public void testResult() {
        Solution solution = new P剑指_offer_40ZuiXiaoDeKgeShuLcof().new Solution();        // TO TEST
        int[] arr = new int[]{3,2,1};
        int[] re = solution.getLeastNumbers(arr, 2);
        Assert.assertArrayEquals(re,new int[]{1,2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];
        return divided(arr,k);
    }
    private int[] divided(int[] arr,int k){
        while (arr.length > k){
            int[] a1 = Arrays.copyOf(arr,arr.length/2);
            int[] a2 = Arrays.copyOfRange(arr,arr.length/2,arr.length);
            int[] r1 = divided(a1, k);
            int[] r2 = divided(a2, k);
            int[] r3 = new int[r1.length+r2.length];
            System.arraycopy(r1, 0, r3, 0, r1.length);
            System.arraycopy(r2, 0, r3, r1.length, r2.length);
            Arrays.sort(r3);
            return Arrays.copyOfRange(r3,0,k);
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}