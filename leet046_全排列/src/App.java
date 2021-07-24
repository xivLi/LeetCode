import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        Solution2 so = new Solution2();
        so.permute(new int[] { 1, 2, 3 });
    }
}

class Solution {
    List<List<Integer>> ans;
    boolean[] status;

    public List<List<Integer>> permute(int[] nums) {
        int[] el = new int[nums.length];
        status = new boolean[nums.length]; // 默认false
        ans = new ArrayList<>();

        find(0, nums, el);

        return ans;
    }

    /*
     * index : 考虑第index位，从0开始
     * 
     */
    private void find(int index, int[] nums, int[] el) {
        for (int i = 0; i < el.length; i++) {
            if (!status[i]) {
                el[index] = nums[i];
                if (index == nums.length - 1) {
                    ans.add(Arrays.stream(el).boxed().collect(Collectors.toList()));
                } else {
                    status[i] = true;
                    find(index + 1, nums, el);
                    status[i] = false;
                }
            }
        }
    }
}

class Solution2 {
    List<List<Integer>> ans;
    boolean[] status;

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> el = new ArrayList<>();
        status = new boolean[nums.length]; // 默认false
        ans = new ArrayList<>();

        find(0, nums, el);

        return ans;
    }

    /*
     * index : 考虑第index位，从0开始
     * 
     */
    private void find(int index, int[] nums, List<Integer> el) {
        for (int i = 0; i < nums.length; i++) {
            if (!status[i]) {
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