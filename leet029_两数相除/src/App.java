public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
        so.divide(-2147483648, 2);
    }
}

// 纯减法
class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
        } else if (divisor == Integer.MIN_VALUE) {
            return 0;
        }

        boolean lastCheck = false;

        int zf = 1;

        if (dividend < 0) {
            if (dividend == Integer.MIN_VALUE) {
                dividend = Integer.MAX_VALUE;
                lastCheck = true;
            } else {
                dividend = -dividend;
            }
            zf = -zf;
        }
        if (divisor < 0) {
            zf = -zf;
            divisor = -divisor;
        }
        int ans = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            ans++;
        }
        if (lastCheck) {
            dividend++;
            if (dividend >= divisor) {
                ans++;
            }
        }

        return zf == 1 ? ans : -ans;
    }
}

// 除数乘2优化
class Solution2 {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
        } else if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            }
            return 0;
        }
        boolean lastCheck = false;

        int zf = 1;

        if (dividend < 0) {
            if (dividend == Integer.MIN_VALUE) {
                dividend = Integer.MAX_VALUE;
                lastCheck = true;
            } else {
                dividend = -dividend;
            }
            zf = -zf;
        }
        if (divisor < 0) {
            zf = -zf;
            divisor = -divisor;
        }
        int ans = 0;
        int fake = divisor + divisor;
        if (fake > divisor) {
            while (dividend >= fake) {
                dividend -= fake;
                ans += 2;
            }
        }

        while (dividend >= divisor) {
            dividend -= divisor;
            ans++;
        }
        if (lastCheck) {
            dividend++;
            if (dividend >= divisor) {
                ans++;
            }
        }

        return zf == 1 ? ans : -ans;
    }
}