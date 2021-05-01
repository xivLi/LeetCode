import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 22;
        Solution s = new Solution();
        int[] ans = s.twoSum(nums, target);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        
        return new int[] { -1, -1 };
    }
}