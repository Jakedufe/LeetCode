//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 351 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：杨辉三角
//2020-09-22 21:29:50
public class P118PascalsTriangle {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P118PascalsTriangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();
            if (numRows == 0) return res;
            Map<Integer, List<Integer>> hashMap = new HashMap<>();
            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            res.add(list1);
            if (numRows == 1) {
                return res;
            }
            List<Integer> list2 = new ArrayList<>();
            list2.add(1);
            list2.add(1);
            res.add(list2);
            int index = 2;
            hashMap.put(index, list2);
            while (index < numRows) {
                List<Integer> list = hashMap.get(index);
                List<Integer> listNew = new ArrayList<>();
                listNew.add(1);
                for (int i = 0; i < list.size() - 1; i++) {
                    listNew.add(list.get(i) + list.get(i + 1));
                }
                listNew.add(1);
                res.add(listNew);
                index++;
                hashMap.put(index, listNew);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}