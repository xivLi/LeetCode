public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
        int[] nums = { 1, 1, 2, 2, 3, 3, 4 };
        so.removeElement(nums, 2);
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int index = 0;
        int pos = 0;
        while (index < n) {
            if (nums[index] != val) {
                nums[pos] = nums[index];
                pos++;
            }
            index++;
        }
        return pos;
    }
}