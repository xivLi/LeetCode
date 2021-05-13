public class App {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            int temp = num % 10;
            num /= 10;
            while (num > 0) {
                temp += num % 10;
                num /= 10;
            }
            num = temp;
        }
        return num;
    }
}