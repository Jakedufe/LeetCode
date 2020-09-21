//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 43 👎 0


package leetcode.editor.cn.offerFirstTime;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
//Java：第一个只出现一次的字符
public class P剑指_offer_50DiYiGeZhiChuXianYiCiDeZiFuLcof{
    
    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P剑指_offer_50DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        Map<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)){
                Integer times = hashMap.get(c);
                hashMap.put(c,times+1);
            }else {
                hashMap.put(c,1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.get(c)==1) return c;
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}