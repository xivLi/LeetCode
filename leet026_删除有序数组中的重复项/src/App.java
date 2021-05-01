public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
        int[] nums = { 1, 2, 3, 3, 4, 4, 5 };
        so.removeDuplicates(nums);
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int trueIndex = 0;
        int index = 1;
        while (index < n) {
            if (nums[index] != nums[trueIndex]) {
                trueIndex++;
                nums[trueIndex] = nums[index];
            }
            index++;
        }
        return trueIndex + 1;
    }
}