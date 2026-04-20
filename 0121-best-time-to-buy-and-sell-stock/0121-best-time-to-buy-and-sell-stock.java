class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] minimum=new int[n];
        int minnum=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            minnum=Math.min(minnum,prices[i]);
            minimum[i]=minnum;
        }
        int maxprofit=0;
        for(int i=0;i<n;i++){
            maxprofit=Math.max(maxprofit,prices[i]-minimum[i]);
        }
        return maxprofit;
    }
}