class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char result=' ';
        int value=target-'a';
        for(int i=0;i<letters.length;i++){
            if(value<letters[i]-'a'){
                result=letters[i];
                break;
            }
        }
        if(result==' '){
            return letters[0];
        }
        else{
            return result;
        }
    }
}
