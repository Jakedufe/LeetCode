//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序 
// 👍 92 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
//Java：把数组排成最小的数
public class P剑指_offer_45BaShuZuPaiChengZuiXiaoDeShuLcof{
    
    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P剑指_offer_45BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String minNumber(int[] nums) {
            String[] nodes = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                nodes[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(nodes, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    StringBuilder sb1 = new StringBuilder(s1);
                    StringBuilder sb2 = new StringBuilder(s2);
                    StringBuilder append1 = sb1.append(s2);
                    StringBuilder append2 = sb2.append(s1);
                    return append1.toString().compareTo(append2.toString());
//                    if (sb1.length() > sb2.length()) {
//                        while (sb1.length() > sb2.length() && sb1.substring(0, sb2.length()).equals(sb2.toString())) {
//                            sb1.delete(0, sb2.length());
//                        }
//                    } else {
//                        while (sb2.length() > sb1.length() && sb2.substring(0, sb1.length()).equals(sb1.toString())) {
//                            sb2.delete(0, sb1.length());
//                        }
//                    }
//                    s1 = sb1.toString();
//                    s2 = sb2.toString();
//                    for (int i = 0; i < s1.length() && i < s2.length(); i++) {
//                        if (s1.charAt(i) == s2.charAt(i)) {
//                        } else return s1.charAt(i) - s2.charAt(i);
//                    }
//                    return s1.length() - s2.length();
                }
            });
            String s = process(nodes);
            return s;
        }

        private String process(String[] nodes) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nodes.length; i++) {
                sb.append(nodes[i]);
            }
            return sb.toString();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}