import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        int left = 0, right = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                right++;
            } else {
                if (left < right) {
                    ans.add(nums[left] + "->" + nums[right]);
                } else {
                    ans.add(String.valueOf(nums[left]));
                }
                left = right = i;
            }
        }
        if (left < right) {
            ans.add(nums[left] + "->" + nums[right]);
        } else {
            ans.add(String.valueOf(nums[left]));
        }
        return ans;
    }
}