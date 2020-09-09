//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都
//是O(1)。 
//
// 若队列为空，pop_front 和 max_value 需要返回 -1 
//
// 示例 1： 
//
// 输入: 
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
// 
//
// 示例 2： 
//
// 输入: 
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= push_back,pop_front,max_value的总操作数 <= 10000 
// 1 <= value <= 10^5 
// 
// Related Topics 栈 Sliding Window 
// 👍 140 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//Java：队列的最大值
//2020-09-08 21:01:10
public class P剑指_offer_59__i_iDuiLieDeZuiDaZhiLcof {

    @Test
    public void testResult() {
        //TO TEST
//        Solution solution = new P剑指_offer_59__i_iDuiLieDeZuiDaZhiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MaxQueue {
        int[] arr;
        int l;
        int r;
        int max;
        int index;

        public MaxQueue() {
            arr = new int[100000];
            l = 0;
            r = 0;
            index = r;
        }

        public int max_value() {
            if (r > l)
                return max;
            else
                return -1;
        }

        public void push_back(int value) {
            arr[r++] = value;
            if (value > max) {
                max = value;
                index = r - 1;
            }
        }

        public int pop_front() {
            if (r > l) {
                if (index == l) {
                    max = Integer.MIN_VALUE;
                    for (int i = l + 1; i < r; i++) {
                        if (arr[i] > max) {
                            max = arr[i];
                            index = i;
                        }
                    }
                }
                return arr[l++];
            } else return -1;
        }
    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

}