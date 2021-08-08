import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(head + ans.get(j));
            }
            head <<= 1;
        }
        return ans;

    }
}