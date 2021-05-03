import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
        System.out.println(so.isHappy(2));
    }
}

// 使用HashSet
class Solution {
    public boolean isHappy(int n) {
        long num = n;
        long newNum = 0;
        Set<Long> set = new HashSet<>();
        set.add((long) n);
        while (num > 0) {
            newNum += (long) Math.pow(num % 10, 2);
            num /= 10;
        }
        if (newNum == 1) {
            return true;
        }
        while (!set.contains(newNum)) {
            set.add(newNum);
            num = newNum;
            newNum = 0;
            while (num > 0) {
                newNum += (long) Math.pow(num % 10, 2);
                num /= 10;
            }
            if (newNum == 1) {
                return true;
            }
        }
        return false;
    }
}

// 快慢指针
class Solution2 {
    public boolean isHappy(int n) {
        long fast = getNext(n);
        if (fast == 1) {
            return true;
        }
        long slow = n;

        while (slow != fast) {
            slow = getNext(slow);
            fast = getNext(fast);
            fast = getNext(fast);
            if (fast == 1) {
                return true;
            }

        }
        return false;
    }

    private long getNext(long n) {
        long newNum = 0;
        while (n > 0) {
            newNum += (long) Math.pow(n % 10, 2);
            n /= 10;
        }
        return newNum;
    }
}