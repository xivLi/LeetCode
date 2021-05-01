import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        int x = 121;
        // String str = Integer.toString(x);
        // System.out.println(str);
        Solution2 s = new Solution2();
        boolean b = s.isPalindrome(x);
        System.out.println(b);
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x > 0)
            return false;
        String str = Integer.toString(x);
        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1 - i) {
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    return false;
                }
            } else
                break;
        }
        return true;
    }
}

class Solution2 {
    public boolean isPalindrome(int x) {
        if (x == 0)
            return true;
        if (x < 0 || x % 10 == 0)
            return false;
        List<Integer> arr = new ArrayList<>();
        while (x != 0) {
            int tail = x % 10;
            arr.add(tail);
            x /= 10;
        }
        int index = 0;
        while (index < arr.size() - index - 1) {
            if (arr.get(index) != arr.get(arr.size() - index - 1)) {
                return false;
            }
            index++;
        }
        return true;
    }
}