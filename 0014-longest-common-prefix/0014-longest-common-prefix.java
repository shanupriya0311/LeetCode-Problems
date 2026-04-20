class Solution {
    public String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        int n = str.length();

        // ✅ find smallest string
        for (int i = 1; i < strs.length; i++) {
            if (n > strs[i].length()) {
                str = strs[i];
                n = strs[i].length();
            }
        }

        int minprefix = n;

        // ✅ compare with smallest string
        for (int i = 0; i < strs.length; i++) {
            int j = 0;

            while (j < n && str.charAt(j) == strs[i].charAt(j)) {
                j++;
            }

            if (j == 0) return "";

            minprefix = Math.min(minprefix, j);
        }

        return str.substring(0, minprefix);
    }
}