import java.util.*;

class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1) return s;

        List<List<Character>> arr = new ArrayList<>();

        // ✅ initialize rows
        for (int l = 0; l < numRows; l++) {
            arr.add(new ArrayList<>());
        }

        int k = 0;

        // simulate zigzag
        while (k < n) {

            // ⬇️ going down
            for (int i = 0; i < numRows && k < n; i++) {
                arr.get(i).add(s.charAt(k++)); // ✅ use add()
            }

            // ⬆️ going up diagonally
            for (int i = numRows - 2; i > 0 && k < n; i--) {
                arr.get(i).add(s.charAt(k++)); // ✅ use add()
            }
        }

        // ✅ build result
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (char c : arr.get(i)) {
                result.append(c);
            }
        }

        return result.toString();
    }
}