public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] change = new int[101];
        for (int i = 0; i < logs.length; i++) {
            change[logs[i][0] - 1950]++;
            change[logs[i][1] - 1950]--;
        }
        int max = change[0];
        int year = 0;
        for (int i = 1; i < change.length; i++) {
            change[i] += change[i - 1];
            if (change[i] > max) {
                max = change[i];
                year = i;
            }
        }
        return year + 1950;
    }
}