public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
    }
}

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                ans = i - 1;
                break;
            }
        }
        return ans;
    }
}