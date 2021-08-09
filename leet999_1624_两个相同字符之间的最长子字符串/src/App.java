public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] head = new int[26];
        boolean[] tail = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (head[index] == 0) {
                head[index] = i + 1;
            }
        }
        int max = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int index = s.charAt(i) - 'a';
            if (!tail[index]) {
                tail[index] = true;
                if (i + 1 != head[index]) {
                    int temp = i + 1 - head[index] - 1;
                    max = Math.max(temp, max);
                }
            }
        }
        return max;
    }
}