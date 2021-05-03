public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
    }
}

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int box1 = 0, box2 = 0;
        for (int i : bills) {
            switch (i) {
                case 5:
                    box1++;
                    break;
                case 10:
                    if (box1 == 0) {
                        return false;
                    }
                    box2++;
                    box1--;
                    break;
                case 20:
                    if (box1 == 0) {
                        return false;
                    }
                    if (box2 == 0 && box1 < 3) {
                        return false;
                    }
                    if (box2 != 0) {
                        box2--;
                        box1--;
                    } else {
                        box1 -= 3;
                    }
            }
        }
        return true;
    }
}