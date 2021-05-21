import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 使用set
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int first, second, third;
        first = second = third = Integer.MIN_VALUE;
        for (Integer integer : set) {
            if (integer > first) {
                third = second;
                second = first;
                first = integer;
            } else if (integer > second) {
                third = second;
                second = integer;
            } else if (integer > third) {
                third = integer;
            }
        }
        return set.size() > 2 ? third : first;
    }
}