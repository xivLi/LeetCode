import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(arr);
        int index = 0;
        while (index < arr.length && arr[index] <= 0) {
            if (set.contains(2 * arr[index])) {
                return true;
            }
            set.add(arr[index]);
            index++;
        }
        index = arr.length - 1;
        while (index >= 0 && arr[index] > 0) {
            if (set.contains(2 * arr[index])) {
                return true;
            }
            set.add(arr[index]);
            index--;
        }
        return false;
    }
}