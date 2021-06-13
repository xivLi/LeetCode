public class App {
    public static void main(String[] args) throws Exception {
        // int a = 2 << 1; // a: 4
        // int b = 2 << 2; // b: 8

        // int c = -2 << 1;
        // int d = -2 << 2;
        // int e = 1;

        // int a = -2;
        // System.out.println("a: " + a);
        // System.out.println(Integer.toBinaryString(a));
        // System.out.println(Integer.toHexString(a));

        // int b = a >>> 1;
        // System.out.println("b: " + b + " Integer最大值: " + Integer.MAX_VALUE);
        // System.out.println(Integer.toBinaryString(b));
        // System.out.println(Integer.toHexString(b));

        // int bb = b << 1;
        // System.out.println("bb: " + bb);
        // System.out.println(Integer.toBinaryString(bb));
        // System.out.println(Integer.toHexString(bb));

        // int c = a >> 1;
        // System.out.println("c: " + c);
        // System.out.println(Integer.toBinaryString(c));
        // System.out.println(Integer.toHexString(c));

        // short a = -1;
        // System.out.println(a + " " + (a >>> 1) + " " + Integer.MAX_VALUE); // -1
        // 2147483647 2147483647

        long a = -1;
        System.out.println(a + " " + (a >>> 1) + " " + Long.MAX_VALUE); // -1 9223372036854775807 9223372036854775807
    }
}

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.toBinaryString(i).replaceAll("0", "").length();
        }
        return ans;
    }
}

class Solution2 {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        if (n == 0) {
            return ans;
        }
        ans[1] = 1;
        for (int i = 2; i < ans.length; i++) {
            if (i % 2 == 0) {
                ans[i] = ans[i >> 1];
            } else {
                ans[i] = ans[i >> 1] + 1;
            }
        }
        return ans;
    }
}