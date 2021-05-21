import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length; // m行n列
        int[][] pre = new int[m + 1][n + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                list.add(pre[i][j]);
            }
        }
        // Collections.sort(list, new Comparator<Integer>() {
        // public int compare(Integer num1, Integer num2) {
        // return num2 - num1;
        // }
        // });
        // lambda 形式
        Collections.sort(list, (num1, num2) -> num2 - num1);
        return list.get(k - 1);
    }
}