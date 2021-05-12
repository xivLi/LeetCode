public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public int maximum69Number(int num) {
        String str = String.valueOf(num);
        int i = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) == '6') {
                break;
            }
        }
        if (i < str.length()) {
            num += 3 * Math.pow(10, str.length() - i - 1);
        }
        return num;
    }
}