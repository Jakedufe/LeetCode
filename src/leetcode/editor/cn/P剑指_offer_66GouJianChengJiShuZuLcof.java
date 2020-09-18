//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i
//+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// 👍 49 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：构建乘积数组
//2020-09-18 17:06:12
public class P剑指_offer_66GouJianChengJiShuZuLcof {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P剑指_offer_66GouJianChengJiShuZuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArr(int[] a) {
            int[] l = new int[a.length];
            int[] r = new int[a.length];
            int lPart = 1;
            int rPart = 1;
            for (int i = 0; i < a.length; i++) {
                l[i] = lPart;
                r[a.length - 1 - i] = rPart;
                lPart *= a[i];
                rPart *= a[a.length - 1 - i];
            }
            int[] result = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                result[i] = l[i] * r[i];
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}