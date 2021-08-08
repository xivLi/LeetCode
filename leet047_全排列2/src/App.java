import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
        so.permuteUnique(new int[] { 1, 1, 3 });
    }
}

class Solution {
    List<List<Integer>> ans;
    boolean[] status;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> el = new ArrayList<>();
        status = new boolean[nums.length]; // 默认false
        ans = new ArrayList<>();
        Arrays.sort(nums);
        find(0, nums, el);

        return ans;
    }

    /*
     * index : 考虑第index位的所有可能性，从0开始
     * 
     */
    private void find(int index, int[] nums, List<Integer> el) {
        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!status[i]) {
                if (record.contains(nums[i])) {
                    continue;
                }
                record.add(nums[i]);
                el.add(nums[i]);
                if (index == nums.length - 1) {
                    ans.add(new ArrayList<>(el));
                } else {
                    status[i] = true;
                    find(index + 1, nums, el);
                    status[i] = false;
                }
                el.remove(index);
            }
        }
    }
}