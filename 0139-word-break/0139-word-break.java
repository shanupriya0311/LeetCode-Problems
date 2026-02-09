class Solution {

    Boolean[] memo;   // null = not visited

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()];
        return backtrack(s, wordDict, 0);
    }

    public boolean backtrack(String s, List<String> wordDict, int start) {

        if(start == s.length()) return true;

        // already computed
        if(memo[start] != null) return memo[start];

        for(String word : wordDict){

            int len = word.length();

            if(start + len <= s.length() &&
               s.substring(start, start + len).equals(word)){

                if(backtrack(s, wordDict, start + len)){
                    memo[start] = true;
                    return true;
                }
            }
        }

        memo[start] = false;
        return false;
    }
}
