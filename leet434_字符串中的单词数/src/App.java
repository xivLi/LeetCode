public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public int countSegments(String s) {
        int ans = 0;
        boolean hasWord = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (!hasWord) {
                    hasWord = true;
                }
            } else {
                if (hasWord) {
                    ans++;
                }
                hasWord = false;
            }
        }
        if (hasWord) {
            ans++;
        }
        return ans;
    }
}