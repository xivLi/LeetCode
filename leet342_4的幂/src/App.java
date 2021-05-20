public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }

        while (n >= 4) {
            if (n % 4 != 0) {
                return false;
            }
            n /= 4;

        }
        if (n == 1) {
            return true;
        }

        return false;
    }
}