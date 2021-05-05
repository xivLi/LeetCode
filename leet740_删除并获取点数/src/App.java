import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
        so.deleteAndEarn(new int[] { 4, 10, 10, 8, 1, 4, 10, 9, 7, 6 });
    }
}

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int ans = 0;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int init = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] - nums[i - 1] == 0) {
                init += nums[i];

            } else {
                list.add(init);
                if (nums[i] - nums[i - 1] > 1) {
                    ans += getMax(list);
                    list.clear();
                }
                init = nums[i];
            }
        }
        list.add(init);
        ans += getMax(list);
        return ans;
    }

    private int getMax(List<Integer> list) {
        if (list.size() == 1)
            return list.get(0);
        if (list.size() == 2)
            return Math.max(list.get(0), list.get(1));
        int[] values = new int[list.size()];
        values[0] = list.get(0);
        values[1] = list.get(1);
        values[2] = values[0] + list.get(2);
        int index = 3;
        while (index < list.size()) {
            values[index] = list.get(index) + Math.max(values[index - 2], values[index - 3]);
            index++;
        }
        return Math.max(values[values.length - 1], values[values.length - 2]);
    }

}