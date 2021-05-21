import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!set1.contains(nums1[i])) {
                set1.add(nums1[i]);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (!set2.contains(nums2[i]) && set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        Iterator<Integer> it = set2.iterator();
        int[] ans = new int[set2.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = it.next();
        }

        return ans;
    }
}