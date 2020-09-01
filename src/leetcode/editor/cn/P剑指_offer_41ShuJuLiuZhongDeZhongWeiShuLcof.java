//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数
//值排序之后中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例 1： 
//
// 输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
// 
//
// 示例 2： 
//
// 输入：
//["MedianFinder","addNum","findMedian","addNum","findMedian"]
//[[],[2],[],[3],[]]
//输出：[null,null,2.00000,null,2.50000] 
//
// 
//
// 限制： 
//
// 
// 最多会对 addNum、findMedia进行 50000 次调用。 
// 
//
// 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-strea
//m/ 
// Related Topics 堆 设计 
// 👍 58 👎 0
//解答成功:
//        执行耗时:68 ms,击败了98.77% 的Java用户
//        内存消耗:49.4 MB,击败了99.71% 的Java用户
//Time 34:13

package leetcode.editor.cn;

import org.junit.Test;

import java.util.PriorityQueue;

//Java：数据流中的中位数
public class P剑指_offer_41ShuJuLiuZhongDeZhongWeiShuLcof {

    @Test
    public void testResult() {
        MedianFinder solution = new P剑指_offer_41ShuJuLiuZhongDeZhongWeiShuLcof().new MedianFinder();        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Double cache;
        boolean flag = false;
        int min = 0;
        int max;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            flag = false;
            if (num > min)
                minHeap.offer(num);
            else
                maxHeap.offer(num);
            reSize();
        }

        public double findMedian() {
            if (flag) return cache;
            if (maxHeap.size() == minHeap.size()) {
                cache = (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                if (maxHeap.size() > minHeap.size()) {
                    cache = Double.valueOf(maxHeap.peek());

                } else {
                    cache = Double.valueOf(minHeap.peek());
                }
            }
            flag = true;
            return cache;
        }

        private void reSize() {
            while (maxHeap.size() - minHeap.size() > 1) {
                minHeap.offer(maxHeap.poll());
            }
            while (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());
            }
            if (minHeap.size() > 0)
                min = minHeap.peek();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}