public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public int largestAltitude(int[] gain) {
        int highest = Math.max(0, gain[0]);
        int present = gain[0];
        for (int i = 1; i < gain.length; i++) {
            present += gain[i];
            if (present > highest) {
                highest = present;
            }
        }
        return highest;
    }
}