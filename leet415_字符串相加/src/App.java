public class App {
    public static void main(String[] args) throws Exception {
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(9, 1));
        wall.add(Arrays.asList(6, 3, 1));
        wall.add(Arrays.asList(2, 4, 1, 3));
        Solution so = new Solution();
        System.out.println(so.leastBricks(wall));

    }
}

class Solution {
    public String addStrings(String num1, String num2) {
        int num1Index = num1.length() - 1;
        int num2Index = num2.length() - 1;
        StringBuffer sbf = new StringBuffer();
        int jin = 0;
        while (num1Index >= 0 || num2Index >= 0) {
            int n1 = num1Index >= 0 ? num1.charAt(num1Index) - '0' : 0;
            int n2 = num2Index >= 0 ? num2.charAt(num2Index) - '0' : 0;
            int he = n1 + n2 + jin;
            if (he > 9) {
                he -= 10;
                jin = 1;
            } else {
                jin = 0;
            }
            sbf.append(he);
            num1Index--;
            num2Index--;
        }
        if (jin == 1) {
            sbf.append('1');
        }
        return sbf.reverse().toString();
    }
}