import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();

    }
}

// 使用HashSet
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0) {
            return "";
        }

        Set<Character> set = new HashSet<>();
        int index = 0;
        while (index < strs[0].length()) {
            set.add(strs[0].charAt(index));

            for (int i = 1; i < strs.length; i++) {
                if (index < strs[i].length() && !set.contains(strs[i].charAt(index)) || index == strs[i].length()) {
                    return strs[0].substring(0, index);
                }
            }
            index++;
            set.clear();
        }

        return strs[0];
    }
}

// 字符哨兵
class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0) {
            return "";
        }

        int index = 0;
        while (index < strs[0].length()) {
            char ch = strs[0].charAt(index);

            for (int i = 1; i < strs.length; i++) {
                if (index < strs[i].length() && ch != strs[i].charAt(index) || index == strs[i].length()) {
                    return strs[0].substring(0, index);
                }
            }
            index++;
        }

        return strs[0];
    }
}