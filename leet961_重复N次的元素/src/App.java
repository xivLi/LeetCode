import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    // 使用set
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        set.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                ans = nums[i];
                break;
            } else {
                set.add(nums[i]);
            }
        }
        return ans;
    }
}