//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。 
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。 
//
// 
//
// 示例 1： 
//
// 输入：n = 12
//输出：5
// 
//
// 示例 2： 
//
// 输入：n = 13
//输出：6 
//
// 
//
// 限制： 
//
// 
// 1 <= n < 2^31 
// 
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/ 
// Related Topics 数学 
// 👍 81 👎 0


package leetcode.editor.cn.offerFirstTime;

import org.junit.Test;

//Java：1～n整数中1出现的次数
public class P剑指_offer_43OneNzhengShuZhong1chuXianDeCiShuLcof {

    @Test
    public void testResult() {
        Solution solution = new P剑指_offer_43OneNzhengShuZhong1chuXianDeCiShuLcof().new Solution();        // TO TEST
        int i = solution.countDigitOne(12345678);
//        solution.test(12345678);
        System.out.println(i);
//         System.out.println(solution.c(12345678));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
            int total = 0;
            String s = String.valueOf(n);
            int len = s.length();
            int[] dp = new int[len + 1];
            dp[1] = 1;//0-9
            int ten = 1;
            for (int i = 2; i < len + 1; i++) {
                dp[i] = dp[i - 1] * 10 + 10 * ten;
                ten *= 10;
            }
            ten = 1;
            for (int i = 0; i < s.length() - 1; i++) {
                ten *= 10;
            }
            for (int i = 0; i < s.length(); i++) {
                int value = s.charAt(i) - '0';
                total += value * dp[len - i - 1];
//                System.out.println(total + "  " + ten + "  " + dp[len - i - 1]);
                if (value >= 2) total += ten;
                else if (value >= 1 && i + 1 < len) {
                    total += Integer.parseInt(s.substring(i + 1)) + 1;
                }else if (value >= 1) total++;
                if (ten == 0 && value >= 1) total++;
                ten /= 10;
                System.out.println(total);
            }

            return total;
        }

        private int c(int n) {
            int total = 0;
            for (int i = 1; i <= n; i++) {
                String s = String.valueOf(i);
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == '1') total++;
                }
            }
            return total;
        }

        private void test(int n) {
            String s = String.valueOf(n);
            int a = 10;
            for (int i = 0; i < s.length(); i++) {
                System.out.println(i + "   " + c(a - 1));
                a = a * 10;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}