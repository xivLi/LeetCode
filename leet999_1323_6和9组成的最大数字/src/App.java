public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // 返回数组
        int[] ans = new int[queries.length];
        // 计算 0-i 的异或
        int[] xorArr = new int[arr.length];
        xorArr[0] = arr[0];
        for (int i = 1; i < xorArr.length; i++) {
            xorArr[i] = xorArr[i - 1] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            if (left > 0) {
                ans[i] = xorArr[left - 1] ^ xorArr[right];
            } else {
                ans[i] = xorArr[right];
            }

        }
        return ans;
    }
}