import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    // 使用TreeMap, 之后进行k次遍历map的keySet()
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String s = null;
            int c = 0;
            for (String string : map.keySet()) {
                if (map.get(string) > c) {
                    s = string;
                    c = map.get(string);
                }
            }
            list.add(s);
            map.remove(s);
        }
        return list;
    }

    // 使用Map, 之后放入list, 然后排序
    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        List<String> list = new ArrayList<>();

        for (String string : map.keySet()) {
            list.add(string);
        }
        Collections.sort(list, (word1, word2) -> map.get(word1) == map.get(word2) ? word1.compareTo(word2)
                : map.get(word2) - map.get(word1));
        return list.subList(0, k);
    }
}