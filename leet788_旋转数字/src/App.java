public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
    }
}

class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (pan(i)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean pan(int i) {
        // 逐位判断
        boolean has2569 = false;
        while (i > 0) {
            int ge = i % 10;
            if (ge == 2 || ge == 5 || ge == 6 || ge == 9) {
                has2569 = true;
            } else if (ge == 3 || ge == 4 || ge == 7) {
                return false;
            }
            i /= 10;
        }

        return has2569;
    }
}