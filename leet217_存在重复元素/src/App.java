import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer integer : nums) {
            if (set.contains(integer)) {
                return true;
            } else {
                set.add(integer);
            }
        }
        return false;
    }
}