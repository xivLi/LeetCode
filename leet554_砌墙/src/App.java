import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(9, 1));
        wall.add(Arrays.asList(6, 3, 1));
        wall.add(Arrays.asList(2, 4, 1, 3));
        Solution so = new Solution();
        System.out.println(so.leastBricks(wall));

    }
}

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> hash = new HashMap<>();

        for (List<Integer> list : wall) {
            int init = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                init += list.get(i);
                if (hash.containsKey(init)) {
                    hash.put(init, hash.get(init) + 1);
                } else {
                    hash.put(init, 1);
                }
            }
        }
        int max = 0;
        for (Integer i : hash.values()) {
            max = Math.max(max, i);
        }

        return wall.size() - max;
    }
}