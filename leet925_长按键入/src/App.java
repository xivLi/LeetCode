public class App {
    public static void main(String[] args) throws Exception {
        Solution so = new Solution();
    }
}

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int indexName = 0, indexTyped = 0;
        if (name.charAt(indexName) != typed.charAt(indexTyped)) {
            return false;
        }
        indexName++;
        indexTyped++;

        while (indexName < name.length() && indexTyped < typed.length()) {
            if (name.charAt(indexName) == typed.charAt(indexTyped)) {
                indexName++;
                indexTyped++;
            } else {
                if (name.charAt(indexName - 1) == typed.charAt(indexTyped)) {
                    indexTyped++;
                } else {
                    return false;
                }
            }
        }

        while (indexTyped < typed.length()) {
            if (name.charAt(indexName - 1) == typed.charAt(indexTyped)) {
                indexTyped++;
            } else {
                return false;
            }
        }

        if (indexName == name.length() && indexTyped == typed.length())
            return true;

        return false;
    }
}