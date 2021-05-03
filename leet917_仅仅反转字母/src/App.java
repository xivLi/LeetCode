import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
        so.reverseOnlyLetters("ab-cd");
    }
}

// 左右指针
class Solution {
    public String reverseOnlyLetters(String S) {
        char[] charArray = S.toCharArray();
        int left = 0, right = charArray.length - 1;
        while (left < right) {
            while (left < charArray.length && !(charArray[left] <= 'z' && charArray[left] >= 'a')
                    && !(charArray[left] <= 'Z' && charArray[left] >= 'A')) {
                left++;
            }
            while (right > -1 && !(charArray[right] <= 'z' && charArray[right] >= 'a')
                    && !(charArray[right] <= 'Z' && charArray[right] >= 'A')) {
                right--;
            }
            if (left < right) {
                char ch = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = ch;
                left++;
                right--;
            } else {
                break;
            }
        }
        return new String(charArray);
    }
}