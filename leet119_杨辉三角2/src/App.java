import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> upper = new ArrayList<>();
        upper.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> el = new ArrayList<>();
            int left = 0;
            for (int j = 0; j < upper.size(); j++) {
                int right = upper.get(j);
                el.add(left + right);
                left = right;
            }
            el.add(left + 0);
            upper = el;
        }
        return upper;
    }
}