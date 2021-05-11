public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int realSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            realSum += nums[i];
            sum += (i + 1);
        }
        return sum - realSum;
    }
}