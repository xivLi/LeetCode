public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
    }
}

class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            return true;
        }

        int i = 1;
        while (i < s.length()) {
            int j = i;
            int index = 0;
            for (; j < s.length(); j++) {
                if (s.charAt(j) != goal.charAt(index)) {
                    break;
                }
                index++;
            }
            if (j == s.length()) {
                for (int j2 = 0; j2 < i; j2++) {
                    if (s.charAt(j2) != goal.charAt(index)) {
                        break;
                    }
                    index++;
                }
                if (index == goal.length()) {
                    return true;
                }
            }
            i++;
        }
        return false;

    }
}