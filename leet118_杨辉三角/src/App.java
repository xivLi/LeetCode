import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> upper = new ArrayList<>();
        upper.add(1);
        ans.add(upper);
        for (int i = 1; i < numRows; i++) {
            List<Integer> el = new ArrayList<>();
            int left = 0;
            for (int j = 0; j < upper.size(); j++) {
                int right = upper.get(j);
                el.add(left + right);
                left = right;
            }
            el.add(left + 0);
            ans.add(el);
            upper = el;
        }
        return ans;
    }
}

class Solution2 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> upper = new ArrayList<>();
        upper.add(1);
        ans.add(upper);
        for (int i = 1; i < numRows; i++) {
            List<Integer> el = new ArrayList<>();
            el.add(0 + upper.get(0));
            int j = 0;
            for (; j < upper.size() - 1; j++) {
                el.add(upper.get(j) + upper.get(j + 1));
            }
            el.add(upper.get(j) + 0);
            ans.add(el);
            upper = el;
        }
        return ans;
    }
}