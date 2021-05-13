import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
        so.minSetSize(new int[] { 3, 3, 3, 3, 5, 5, 5, 2, 2, 7 });
    }
}

class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int[] order = new int[map.size()];
        int start = 0;
        for (int i : map.keySet()) {
            order[start++] = map.get(i);
        }
        Arrays.sort(order);
        int half = arr.length / 2;
        int end = order.length - 1;
        while (half > 0) {
            half -= order[end--];
        }

        return order.length - 1 - end;
    }
}