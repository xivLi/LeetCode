public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
        int[] nums = new int[] { 4, 1, 2, 1, 2 };
        int ans = so.singleNumber(nums);
        System.out.println(ans);
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int init = 0;
        for (int i : nums) {
            init = init ^ i;
        }

        return init;
    }
}