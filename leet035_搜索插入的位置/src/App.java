public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }

        return nums.length;
    }
}