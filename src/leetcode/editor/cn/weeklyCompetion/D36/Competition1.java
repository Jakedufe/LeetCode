package leetcode.editor.cn.weeklyCompetion.D36;

import org.junit.Test;

//Java：周赛
//2020-09-19 15:09:18
public class Competition1 {

    @Test
    public void testResult() {
        //TO TEST


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class ParkingSystem {
        private int big;
        private int medium;
        private int small;
        private int bigCur;
        private int mediumCur;
        private int smallCur;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
            bigCur = 0;
            mediumCur = 0;
            smallCur = 0;
        }

        public boolean addCar(int carType) {
            if (carType == 1) {
                if (bigCur >= big) {
                    return false;
                } else bigCur++;
            } else if (carType == 2) {
                if (mediumCur >= medium) {
                    return false;
                } else mediumCur++;
            } else {
                if (smallCur >= small) {
                    return false;
                } else smallCur++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}