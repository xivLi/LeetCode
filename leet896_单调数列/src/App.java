public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
    }
}

class Solution {
    public boolean isMonotonic(int[] A) {
        boolean flag = false;
        if (A[0] <= A[A.length - 1]) {
            flag = true;
        }

        for (int i = 0; i < A.length - 1; i++) {
            if (flag) {
                if (A[i] > A[i + 1]) {
                    return false;
                }
            } else {
                if (A[i] < A[i + 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}