import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
        so.commonChars(new String[] { "cool", "lock", "cook" });
    }
}

class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();

        Map<Character, Integer> finalRecorder = new HashMap<>();
        for (int i = 0; i < words[0].length(); i++) {
            char c = words[0].charAt(i);
            if (finalRecorder.containsKey(c)) {
                finalRecorder.put(c, finalRecorder.get(c) + 1);
            } else {
                finalRecorder.put(c, 1);
            }
        }
        if (words.length > 1) {
            for (int i = 1; i < words.length; i++) {
                Map<Character, Integer> recorder = new HashMap<>();
                for (int j = 0; j < words[i].length(); j++) {
                    char c = words[i].charAt(j);
                    if (recorder.containsKey(c)) {
                        recorder.put(c, recorder.get(c) + 1);
                    } else {
                        recorder.put(c, 1);
                    }
                }
                for (Character c : finalRecorder.keySet()) {
                    if (recorder.containsKey(c)) {
                        finalRecorder.put(c, Math.min(finalRecorder.get(c), recorder.get(c)));
                    } else {
                        finalRecorder.put(c, 0);
                    }
                }
            }
        }
        for (Character c : finalRecorder.keySet()) {
            for (int i = 0; i < finalRecorder.get(c); i++) {
                ans.add(String.valueOf(c));
            }
        }

        return ans;
    }
}

class Solution2 {
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();

        byte[] minfreq = new byte[26];
        Arrays.fill(minfreq, Byte.MAX_VALUE);
        for (String string : words) {
            byte[] freq = new byte[26];
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minfreq[i] = (byte) Math.min(minfreq[i], freq[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minfreq[i]; j++) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}