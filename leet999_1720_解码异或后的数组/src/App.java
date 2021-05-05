public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] ans = new int[encoded.length + 1];
        ans[0] = first;
        int index = 1;
        while (index < encoded.length) {
            ans[index] = encoded[index - 1] ^ ans[index - 1];
            index++;
        }
        return ans;
    }
}