import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public int[] frequencySort(int[] nums) {
        int[] counts = new int[201];
        for (int i : nums) {
            counts[i + 100]++;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = counts[nums[i] + 100] * 1000 + (100 - nums[i]);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 100 - nums[i] % 1000;
        }
        return nums;
    }
}