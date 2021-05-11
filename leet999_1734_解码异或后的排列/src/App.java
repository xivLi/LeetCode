import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    // 暴力行不通
    public int[] decode(int[] encoded) {
        int[] ans = new int[encoded.length + 1];
        Set<Integer> set = new HashSet<>();
        int first = 1;
        while (first <= ans.length) {
            ans[0] = first;
            set.add(ans[0]);
            for (int i = 1; i < ans.length; i++) {
                ans[i] = ans[i - 1] ^ encoded[i - 1];
                if (ans[i] > ans.length || !set.add(ans[i])) {
                    break;
                }
            }
            if (set.size() == ans.length) {
                break;
            }
            set.clear();
            first++;
        }
        return ans;
    }

    // 先解出第个一值
    public int[] decode2(int[] encoded) {
        int[] ans = new int[encoded.length + 1];
        int totalFromN = 0;
        for (int i = 1; i <= encoded.length + 1; i++) {
            totalFromN ^= i;
        }
        int totalFromEn = 0;
        for (int i = 1; i < encoded.length;) {
            totalFromEn ^= encoded[i];
            i += 2;
        }
        ans[0] = totalFromEn ^ totalFromN;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] ^ encoded[i - 1];
        }
        return ans;
    }
}
