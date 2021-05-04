import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
        so.restoreIpAddresses("25525511135");
    }
}

class Solution {
    private List<String> ans;
    private int[] el;

    public List<String> restoreIpAddresses(String s) {

        ans = new ArrayList<>();

        if (s.length() > 12 || s.length() < 4) {
            return ans;
        }

        el = new int[4];
        getEl(s.toCharArray(), 0, 0);
        return ans;
    }

    private void getEl(char[] chs, int sIndex, int elIndex) {
        int init = 0;
        while (sIndex < chs.length) {
            init = init * 10 + chs[sIndex] - '0';
            // 剪枝
            if (init > 255) {
                return;
            }
            el[elIndex] = init;
            sIndex++;

            if (elIndex == 3 && sIndex == chs.length) {
                ans.add(el[0] + "." + el[1] + "." + el[2] + "." + el[3]);
                return;
            } else if (elIndex < 3) {
                if (chs.length - sIndex > 3 * (3 - elIndex) || chs.length - sIndex < 3 - elIndex) {
                    // 剪枝
                    if (init == 0) {
                        return;
                    }
                    continue;
                }
                getEl(chs, sIndex, elIndex + 1);
            }
            // 剪枝
            if (init == 0) {
                return;
            }
        }
        return;
    }
}