public class App {
    public static void main(String[] args) throws Exception {
        int x = -7;
        Solution s = new Solution();
        int ans = s.reverse(x);
        System.out.println(ans);
        // int x = -123;
        // System.out.println(x % 10);
        // System.out.println(x / 10);
    }
}

class Solution {
    public int reverse(int x) {
        long ans = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        while (x / 10 != 0) {
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        ans = ans * 10 + x % 10;
        if (ans > max || ans < min) {
            return 0;
        }
        return (int) ans;
    }
}