public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public String sortSentence(String s) {
        String[] els = s.split(" ");
        int[] match = new int[els.length];
        for (int i = 0; i < els.length; i++) {
            int index = els[i].charAt(els[i].length() - 1) - '1';
            els[i] = els[i].substring(0, els[i].length() - 1);
            match[index] = i;
        }
        String ans = els[match[0]];
        for (int i = 1; i < match.length; i++) {
            ans += " " + els[match[i]];
        }
        return ans;
    }
}