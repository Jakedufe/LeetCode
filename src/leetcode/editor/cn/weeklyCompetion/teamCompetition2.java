//小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小
//A 猜对了几次？ 
//
// 
//
// 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。 
//
// 
//
// 示例 1： 
//
// 输入：guess = [1,2,3], answer = [1,2,3]
//输出：3
//解释：小A 每次都猜对了。 
//
// 
//
// 示例 2： 
//
// 输入：guess = [2,2,3], answer = [3,2,1]
//输出：1
//解释：小A 只猜对了第二次。 
//
// 
//
// 限制： 
//
// 
// guess的长度 = 3 
// answer的长度 = 3 
// guess的元素取值为 {1, 2, 3} 之一。 
// answer的元素取值为 {1, 2, 3} 之一。 
// 
// 👍 112 👎 0


package leetcode.editor.cn.weeklyCompetion;

import org.junit.Test;

import java.util.Arrays;

//Java：猜数字
//2020-09-19 15:09:18
public class teamCompetition2 {

    @Test
    public void testResult() {
        //TO TEST
        Solution solution = new teamCompetition2().new Solution();
        System.out.println(solution.isMagic(new int[]{2,4,3,1,5}));

    }

    //0 1
//0 0 4 4 1
//0 0 0 6 0 9 6 18 9 1
//0 0 0 0 8 0 0 16 12 0 48 0 36 32 48 16 1
//0 0 0 0 0 10 0 0 0 25 20 0 0 100 0 20 100 100 0 200 10 100 100 100 25 1
//0 0 0 0 0 0 12 0 0 0 0 36 30 0 0 0 180 0 40 0 225 240 0 0 600 0 180 400 450 0 600 72 225 240 180 36 1
//0 1
//0 0 4 4 1
//0 0 0 6 0 9 6 18 9 1
//0 0 0 0 8 0 0 16 12 0 48 0 8 32 48 16 1
//0 0 0 0 0 10 0 0 0 25 20 0 0 100 0 20 100 100 0 200 10 50 100 100 25 1
//0 0 0 0 0 0 12 0 0 0 0 36 30 0 0 0 180 0 40 0 225 240 0 0 30 0 180 400 450 0 12 72 180 240 180 36 1
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean flag = false;

        public boolean isMagic(int[] target) {
            int[] s = new int[target.length];
            int k = 0;
            for (int i = 0; i < target.length; i++) {
                s[i] = i + 1;
            }
            while (k==0){
                while (k < target.length && s[k] == target[k]) k++;
                int[] copy = Arrays.copyOf(s, s.length);
                int end = 0;
                int i = end + 1, j = end;
                for (; i < s.length; i = i + 2, j++) {
                    s[j] = s[i];
                }
                for (j++, i = end; j < s.length; j++, i = i + 2) {
                    s[j] = copy[i];
                }
            }

            for (int i = k; i > 0; i--) {
                isM(target, s, k, 0);
                if (flag) break;
            }
            return flag;
        }

        private void isM(int[] target, int[] s, int k, int start) {
            for (int i = 0; i < s.length; i++) {
                System.out.print(s[i]);
            }
            System.out.println();
            int end = start;
            while (end < target.length && s[end] == target[end]) end++;
            if (end - start >= k) end = start + k;
            else return;
            int[] copy = Arrays.copyOf(s, s.length);
            int i = end + 1, j = end;
            for (; i < s.length; i = i + 2, j++) {
                s[j] = s[i];
            }
            for (j++, i = end; j < s.length; j++, i = i + 2) {
                s[j] = copy[i];
            }
            isM(target, s, k, end);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}