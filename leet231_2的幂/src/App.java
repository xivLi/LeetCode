public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        // 考虑n大于1
        while (n != 2) {
            if (n % 2 == 1) {
                return false;
            }
            n /= 2;
        }
        return true;
    }
}