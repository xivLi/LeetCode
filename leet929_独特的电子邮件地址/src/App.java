import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
        so.numUniqueEmails(new String[] { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com" });

    }
}

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String string : emails) {
            String partOne = string.substring(0, string.indexOf('+') != -1 ? string.indexOf('+') : string.indexOf('@'));
            String partTwo = string.substring(string.indexOf('@'), string.length());
            // 两种replaceAll都可以
            set.add(partOne.replaceAll("[/.]", "") + partTwo);
            // set.add(partOne.replaceAll("\\.", "") + partTwo);
        }
        for (String string : set) {
            System.out.println(string);
        }
        System.out.println(set.size());
        return set.size();
    }
}