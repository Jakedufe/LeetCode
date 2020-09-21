//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 
//
// 
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
//.05556,0.02778] 
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
// 👍 106 👎 0


package leetcode.editor.cn.offerFirstTime;

import org.junit.Test;

//Java：n个骰子的点数
//2020-09-08 21:19:17
public class P剑指_offer_60NgeTouZiDeDianShuLcof {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new P剑指_offer_60NgeTouZiDeDianShuLcof().new Solution();
        double[] doubles = solution.twoSum(2);
        for (int i = 0; i < doubles.length; i++) {
            System.out.println(doubles[i]);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] twoSum(int n) {
            double pre[]={1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
            for(int i=2;i<=n;i++){
                double tmp[]=new double[5*i+1];
                for(int j=0;j<pre.length;j++)
                    for(int x=0;x<6;x++)
                        tmp[j+x]+=pre[j]/6;
                pre=tmp;
            }
            return pre;
//            HashMap<Integer, Double> hashMap = new HashMap<>();
//            for (int i = 1; i < 7; i++) {
//                hashMap.put(i, 1/6.0);
//            }
//            HashMap<Integer, Double> old = hashMap;
//            for (int i = 1; i < n; i++) {
//                HashMap<Integer, Double> next = new HashMap<>();
//                for (Integer integer : hashMap.keySet()) {
//                    for (Integer integer1 : old.keySet()) {
//                        int key = integer + integer1;
//                        double v = hashMap.get(integer) * old.get(integer1);
//                        if (next.containsKey(key)) {
//                            Double aDouble = next.get(key);
//                            aDouble += v;
//                            next.put(key, aDouble);
//                        } else {
//                            next.put(key, v);
//                        }
//                    }
//                }
//                old = next;
//            }
//            Integer[] array = old.keySet().toArray(new Integer[0]);
//            Arrays.sort(array);
//            double[] re = new double[array.length];
//            for (int i = 0; i < array.length; i++) {
//                re[i] = old.get(array[i]);
//            }
//            return re;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}