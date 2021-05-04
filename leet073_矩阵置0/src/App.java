import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {

    }
}

// 一个HashSet一个boolean变量
class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            boolean isZeroCurrentRow = false;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    isZeroCurrentRow = true;
                    col.add(j);
                    for (int j2 = 0; j2 < i; j2++) {
                        matrix[j2][j] = 0;
                    }
                } else {
                    if (col.contains(j)) {
                        for (int j2 = 0; j2 <= i; j2++) {
                            matrix[i][j] = 0;
                        }
                    }
                }
            }
            if (isZeroCurrentRow) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;

                }
            }
        }
    }
}

// 两个数组
class Solution2 {
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[i] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

// 利用现有数组的第一行第一列
class Solution3 {
    public void setZeroes(int[][] matrix) {
        boolean isZeroFirstRow = false;
        boolean isZeroFirstCol = false;
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                isZeroFirstRow = true;
                break;
            }
        }
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j][0] == 0) {
                isZeroFirstCol = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (matrix[0][j] != 0) {
                        for (int j2 = 0; j2 < i; j2++) {
                            matrix[j2][j] = 0;
                        }
                    }
                    if (matrix[i][0] != 0) {
                        for (int j2 = 0; j2 < j; j2++) {
                            matrix[i][j2] = 0;
                        }
                    }
                } else if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (isZeroFirstRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (isZeroFirstCol) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }

    }
}