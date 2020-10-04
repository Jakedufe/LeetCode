//给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。 
//
// 示例: 
//
// MovingAverage m = new MovingAverage(3);
//m.next(1) = 1
//m.next(10) = (1 + 10) / 2
//m.next(3) = (1 + 10 + 3) / 3
//m.next(5) = (10 + 3 + 5) / 3
// 
//
// 
// Related Topics 设计 队列 
// 👍 35 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

//Java：数据流中的移动平均值
//2020-09-24 13:52:03
public class P346MovingAverageFromDataStream {

    @Test
    public void testResult() {
        //TO TEST
        MovingAverage solution = new P346MovingAverageFromDataStream().new MovingAverage(1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MovingAverage {

        private int size;
        private int index;
        private int sum;
        boolean isFull;
        int[] queue;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.size = size;
            index = -1;
            sum = 0;
            queue = new int[size];
            isFull = false;
        }

        public double next(int val) {
            if (isFull) {
                sum -= queue[(++index) % size];
                sum += val;
                queue[index % size] = val;
                return sum * 1.0 / size;
            } else {
                queue[++index] = val;
                sum += val;
                if (index == size - 1) {
                    isFull = true;
                }
                return sum * 1.0 / (index + 1);
            }
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}