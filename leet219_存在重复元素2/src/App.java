import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Solution2 so = new Solution2();
        boolean ans = so.containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3);
        System.out.println(ans);
    }
}

// 暴力比较
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j <= k; j++) {
                int index = i + j;
                if (index < nums.length && nums[i] == nums[index]) {
                    return true;
                }
            }

        }
        return false;
    }
}

// 使用HashMap
class Solution2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }

            }
            map.put(nums[i], i);
        }

        return false;
    }
}