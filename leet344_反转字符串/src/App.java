public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public void reverseString(char[] s) {
        int endIndex = s.length - 1;
        for (int i = 0; i < s.length / 2; i++) {
            char c = s[i];
            s[i] = s[endIndex - i];
            s[endIndex - i] = c;
        }

    }
}