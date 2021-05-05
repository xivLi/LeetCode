public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int temp = n;
        if (n < 0) {
            n = n ^ (~0);
        }
        int init = 0;
        while (n > 0) {
            if (n % 2 == 1)
                init++;
            n /= 2;
        }
        return temp > 0 ? init : 32 - init;

    }
}