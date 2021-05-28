public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
        so.totalHammingDistance(new int[] { 4, 14, 2 });
    }
}

class Solution {
    public int totalHammingDistance(int[] nums) {
        // 统计数组最后一位1的个数和0的个数，逐个元素处理
        int ans = 0;
        int[] binary = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int index = 0;
            int num = nums[i];
            while (num > 0) {
                if (num % 2 != 0) {
                    binary[index]++;
                }
                index++;
                num = num >> 1;
            }

        }
        for (int i = 0; i < binary.length; i++) {
            if (binary[i] != 0) {
                ans += (nums.length - binary[i]) * binary[i];
            }
        }
        return ans;
    }

    // 统计数组最后一位1的个数和0的个数，逐位处理
    public int totalHammingDistance2(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }
}