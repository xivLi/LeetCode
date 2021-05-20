import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(words[i])) {
                    return false;
                }
            } else {
                if (set.contains(words[i])) {
                    return false;
                }
                map.put(ch, words[i]);
                set.add(words[i]);

            }
        }
        return true;
    }
}