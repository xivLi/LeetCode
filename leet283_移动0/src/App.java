public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        int zeroNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
            } else {
                if (zeroNum > 0) {
                    nums[i - zeroNum] = nums[i];
                }
            }
        }
        for (int i = nums.length - zeroNum; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}