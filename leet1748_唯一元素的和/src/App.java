import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public int sumOfUnique(int[] nums) {
        // 使用hashmap
        int sum = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], true);
                sum += nums[i];
            } else {
                if (map.get(nums[i])) {
                    sum -= nums[i];
                    map.put(nums[i], false);
                }
            }
        }
        return sum;
    }
}

class Solution2 {
    public int sumOfUnique(int[] nums) {
        // 排序数组
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = 0;
        Arrays.sort(nums);
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                if (i == index + 1) {
                    sum += nums[index];
                }
                index = i;
            }
        }
        if (index == nums.length - 1) {
            sum += nums[index];
        }
        return sum;
    }
}