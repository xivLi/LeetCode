public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) {
            return true;
        }
        int index = 0;
        while (index < bits.length - 1) {
            if (bits[index] == 0) {
                index++;
            } else {
                index += 2;
            }
        }
        if (index == bits.length - 1) {
            return true;
        }
        return false;
    }
}