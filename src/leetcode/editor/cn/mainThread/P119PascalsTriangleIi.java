//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 181 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//Java：杨辉三角 II
//2020-09-23 10:09:07
public class P119PascalsTriangleIi {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P119PascalsTriangleIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> res = new ArrayList<>();
            res.add(1);
            if (rowIndex == 0) return res;
            res.add(1);
            if (rowIndex == 1) {
                return res;
            }
            int index = 1;
            List<Integer> listOld = res;
            List<Integer> listNew = new ArrayList<>();
            while (index < rowIndex) {
                listNew.clear();
                listNew.add(1);
                for (int i = 0; i < listOld.size() - 1; i++) {
                    listNew.add(listOld.get(i) + listOld.get(i + 1));
                }
                listNew.add(1);
                res = listNew;
                listNew = listOld;
                listOld = res;
                index++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}