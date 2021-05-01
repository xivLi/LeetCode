import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution2 so = new Solution2();
        so.letterCombinations("26");
    }
}

class Solution {
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        int[] nums = new int[n];
        char[] el = new char[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(String.valueOf(digits.charAt(i)));
        }
        String[] dic = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        int index = 0;
        for (int i = 0; i < dic[nums[index]].length(); i++) {
            el[index] = dic[nums[index]].charAt(i);
            index = 1;
            if (index < n) {
                for (int j = 0; j < dic[nums[index]].length(); j++) {
                    el[index] = dic[nums[index]].charAt(j);
                    index = 2;
                    if (index < n) {
                        for (int j2 = 0; j2 < dic[nums[index]].length(); j2++) {
                            el[index] = dic[nums[index]].charAt(j2);
                            index = 3;
                            if (index < n) {
                                for (int k = 0; k < dic[nums[index]].length(); k++) {
                                    el[index] = dic[nums[index]].charAt(k);
                                    ans.add(new String(el));
                                }
                            } else {
                                ans.add(new String(el));
                            }
                            index = 2;
                        }
                    } else {
                        ans.add(new String(el));
                    }
                    index = 1;

                }
            } else {
                ans.add(new String(el));
            }
            index = 0;
        }
        return ans;
    }
}

class Solution2 {
    private List<String> ans;
    private String digits;
    String[] dic = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        char[] el = new char[digits.length()];
        putElement(0, el);

        return ans;
    }

    private void putElement(int i, char[] el) {
        int num = Integer.parseInt(digits.substring(i, i + 1));
        String str = dic[num];
        if (i == digits.length() - 1) {
            for (int j = 0; j < str.length(); j++) {
                el[i] = str.charAt(j);
                ans.add(new String(el));
            }
        } else {
            for (int j = 0; j < str.length(); j++) {
                el[i] = str.charAt(j);
                putElement(i + 1, el);
            }
        }
    }
}