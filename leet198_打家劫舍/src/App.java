import java.util.Arraynums;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public int rob(int[] nums) {
        // 数组版
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] values = new int[nums.length];
        values[0] = nums[0];
        values[1] = nums[1];
        values[2] = values[0] + nums[2];
        int index = 3;
        while (index < nums.length) {
            values[index] = nums[index] + Math.max(values[index - 2], values[index - 3]);
            index++;
        }
        return Math.max(values[values.length - 1], values[values.length - 2]);
    }

    public int rob2(int[] nums) {
        // 三个变量版
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int num0 = nums[0];
        int num1 = nums[1];
        int num2 = nums[2];
        int index = 3;
        while (index < nums.length) {
            int newNum = nums[index] + Math.max(num0, num1);
            num0 = num1;
            num1 = num2;
            num2 = newNum;
            index++;
        }
        return Math.max(num1, num2);
    }

}