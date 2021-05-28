import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            if (map1.containsKey(i)) {
                map1.put(i, map1.get(i) + 1);
            } else {
                map1.put(i, 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        // 添加元素
        for (int i : nums2) {
            if (map1.containsKey(i)) {
                if (map1.get(i) == 1) {
                    map1.remove(i);
                } else {
                    map1.put(i, map1.get(i) - 1);
                }
                list.add(i);
            }
        }

        // 使用stream
        int[] ans = list.stream().mapToInt(Integer::intValue).toArray();

        // 遍历赋值
        // int[] ans = new int[list.size()];
        // for (int i = 0; i < ans.length; i++) {
        // ans[i] = list.get(i);
        // }
        return ans;
    }
}