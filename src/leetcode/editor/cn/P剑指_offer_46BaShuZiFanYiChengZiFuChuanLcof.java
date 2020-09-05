//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// 👍 131 👎 0


package leetcode.editor.cn;
import org.junit.Test;
//Java：把数字翻译成字符串
public class P剑指_offer_46BaShuZiFanYiChengZiFuChuanLcof{
    
    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P剑指_offer_46BaShuZiFanYiChengZiFuChuanLcof().new Solution();        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {
            String s = String.valueOf(num);
            int[] count = new int[s.length()];
            int[] x = new int[s.length()];
            int[] y = new int[s.length()];
            count[0] = 1;
            x[0] = 1;
            y[0] = 0;
            for (int i = 1; i < s.length(); i++) {
                int test = Integer.parseInt(s.substring(i - 1, i + 1));
                if (test < 26 && test > 9) {
                    count[i] = x[i - 1] * 2 + y[i - 1];
                    x[i] = x[i - 1] + y[i - 1];
                    y[i] = x[i - 1];
                } else {
                    count[i] = count[i - 1];
                    x[i] = count[i];
                }
            }
            return count[s.length() - 1];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}