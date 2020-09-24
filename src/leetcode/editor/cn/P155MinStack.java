//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 675 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//Java：最小栈
//2020-09-24 10:27:20
public class P155MinStack {

    @Test
    public void testResult() {
        //TO TEST
        MinStack solution = new P155MinStack().new MinStack();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        List<Integer> list;
        int min;
        int top;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            list = new ArrayList<>();
            top = -1;
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            list.add(x);
            top++;
            if (x < min) {
                min = x;
            }
        }

        public void pop() {
            if (list.get(top) == min) update();
            list.remove(top--);
        }

        private void update() {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < top; i++) {
                min = Math.min(min, list.get(i));
            }
        }

        public int top() {
            return list.get(top);
        }

        public int getMin() {
            return min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}