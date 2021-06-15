public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ans = Math.max(count, ans);
                count = 0;
            } else {
                count++;
            }

        }

        return Math.max(count, ans);
    }
}