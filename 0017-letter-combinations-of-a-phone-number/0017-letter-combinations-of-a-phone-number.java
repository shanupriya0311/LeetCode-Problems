class Solution {
    public List<String> letterCombinations(String digits) {
        int n=digits.length();
        if(n==0){
            return new ArrayList<>();
        }
         List<String>result=new ArrayList<>();
         result=find(digits.charAt(0));
         for(int i=1;i<n;i++){
            List<String>sub=new ArrayList<>();
            List<String>subarr=new ArrayList<>();
            sub=find(digits.charAt(i));
            for(String r:result){
            for(String s:sub){
                subarr.add(r+s);
            }  
        }
        result=subarr;
         }
        return result;
    }
    public List<String> find(Character digit){
         switch(digit) {
            case '2': return new ArrayList<>(Arrays.asList("a","b","c"));
            case '3': return new ArrayList<>(Arrays.asList("d","e","f"));
            case '4': return new ArrayList<>(Arrays.asList("g","h","i"));
            case '5': return new ArrayList<>(Arrays.asList("j","k","l"));
            case '6': return new ArrayList<>(Arrays.asList("m","n","o"));
            case '7': return new ArrayList<>(Arrays.asList("p","q","r","s"));
            case '8': return new ArrayList<>(Arrays.asList("t","u","v"));
            case '9': return new ArrayList<>(Arrays.asList("w","x","y","z"));
        }
        return new ArrayList<>();
    }
}