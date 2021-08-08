public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public String reformatNumber(String number) {
        char[] arrays = number.toCharArray();
        StringBuilder ans = new StringBuilder();
        int count = 0;
        char[] temp = new char[5];
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == ' ' || arrays[i] == '-')
                continue;

            if (count == 4) {
                if (ans.length() != 0) {
                    ans.append("-");
                }
                ans.append(String.valueOf(temp, 0, 3));
                temp[0] = temp[3];
                count = 1;
            }
            temp[count++] = arrays[i];
        }
        if (ans.length() != 0) {
            ans.append("-");
        }
        if (count == 2) {
            ans.append(String.valueOf(temp, 0, 2));
        } else if (count == 3) {
            ans.append(String.valueOf(temp, 0, 3));
        } else if (count == 4) {
            ans.append(String.valueOf(temp, 0, 2));
            ans.append("-");
            ans.append(String.valueOf(temp, 2, 2));
        }
        return ans.toString();
    }
}