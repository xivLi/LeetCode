public class App {
    public static void main(String[] args) throws Exception {
        Solution2 so = new Solution2();
        so.strStr("ewfdfsegwefgs", "issip");
        // System.out.println("hello");
    }
}

// 使用String的substring方法-暴力匹配
class Solution {
    public int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}

// KMP
class Solution2 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0 || needle.length() > haystack.length()) {
            return -1;
        }

        // 构造next
        int[] next = new int[needle.length()];
        next[0] = 0;
        for (int i = 1; i < next.length; i++) {
            if (needle.charAt(i) == needle.charAt(next[i - 1])) {
                next[i] = next[i - 1] + 1;
            } else {
                int j = next[i - 1];
                while (j != 0 && needle.charAt(i) != needle.charAt(j)) {
                    j = next[j - 1];
                }
                next[i] = next[j];
                if (needle.charAt(i) == needle.charAt(j)) {
                    next[i]++;
                }
            }
        }
        // 匹配过程
        int index = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(index)) {
                index++;
                if (index == next.length) {
                    return i - next.length + 1;
                }
            } else {
                if (index == 0) {
                    continue;
                }
                index = next[index - 1];
                i--;
            }
        }

        return -1;
    }
}