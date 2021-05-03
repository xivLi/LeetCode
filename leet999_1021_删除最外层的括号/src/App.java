import java.util.ArrayDeque;

public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
        so.removeOuterParentheses("()()");

    }
}

// 使用ArrayDeque
class Solution {
    public String removeOuterParentheses(String S) {
        if (S.length() == 0) {
            return "";
        }
        StringBuffer sbf = new StringBuffer();
        ArrayDeque<Character> adq = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                if (!adq.isEmpty()) {
                    sbf.append(ch);
                }
                adq.push(ch);
            } else {
                if (adq.size() > 1) {
                    adq.pop();
                    sbf.append(ch);
                } else {
                    adq.pop();
                }
            }
        }
        return sbf.toString();
    }
}

// 整型变量控制
class Solution2 {
    public String removeOuterParentheses(String S) {
        if (S.length() == 0) {
            return "";
        }
        StringBuffer sbf = new StringBuffer();
        int numLeft = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                if (numLeft != 0) {
                    sbf.append(ch);
                }
                numLeft++;
            } else {
                if (numLeft > 1) {
                    sbf.append(ch);
                }
                numLeft--;
            }
        }
        return sbf.toString();
    }
}