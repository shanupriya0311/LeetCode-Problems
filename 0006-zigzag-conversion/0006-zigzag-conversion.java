class Solution {
    public String convert(String s, int numRows) {
        int n=s.length();
        List<List<Character>>arr=new ArrayList<>();
        for(int l=0;l<numRows;l++){
           arr.add(new ArrayList<>());
        }
        int k=0;
        int i=0;
        while(k<n){
            for(i=0;i<numRows && k<n;i++){
                arr.get(i).add(s.charAt(k));
                k++;
            }
            for(i=i-2;i>0 && k<n;i--){
                
                arr.get(i).add(s.charAt(k));
                k++;
            }
        }
        StringBuilder result=new StringBuilder();
        for(int j=0;j<numRows;j++){
            for(Character c:arr.get(j)){
                result.append(c);
            }
        }
        return new String(result);
    }
}