import java.util.ArrayDeque;
// import java.util.LinkedList;
// import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        boolean b = s.isValid("");
        System.out.println(b);
    };
}

class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        // LinkedList<Character> stack = new LinkedList<>();
        // Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for (char c : ch) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                default:
                    if (stack.isEmpty()) {
                        return false;
                    }

                    char e = stack.pop(); // 自动拆箱
                    // char e = stack.pop().charValue();

                    switch (e) {
                        case '(':
                            if (c != ')') {
                                return false;
                            }
                            break;
                        case '[':
                            if (c != ']') {
                                return false;
                            }
                            break;
                        case '{':
                            if (c != '}') {
                                return false;
                            }
                            break;
                    }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}