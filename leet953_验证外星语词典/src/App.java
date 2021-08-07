public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();

    }
}

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1) {
            return true;
        }
        int[] alpha = new int[26];
        for (int i = 0; i < order.length(); i++) {
            alpha[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLen = Math.min(word1.length(), word2.length());
            int j = 0;
            for (; j < minLen; j++) {
                int c1 = word1.charAt(j) - 'a';
                int c2 = word2.charAt(j) - 'a';
                if (alpha[c1] > alpha[c2]) {
                    return false;
                } else if (alpha[c1] < alpha[c2]) {
                    break;
                }
            }
            if (j == minLen && word1.length() > word2.length()) {
                return false;
            }
        }
        return true;
    }
}