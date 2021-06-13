public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2; // 为了防止计算溢出
            // 跳出循环前, mid 一定是等于 left 或 left + 1
            if (isBadVersion(mid)) {
                right = mid; // 错误的起点在区间 [left, mid]
            } else {
                left = mid + 1; // 错误的起点在 [mid + 1, right]
            }
        }
        return left;
    }
}

class VersionControl {
    boolean isBadVersion(int version) {
        return true;
    }
}