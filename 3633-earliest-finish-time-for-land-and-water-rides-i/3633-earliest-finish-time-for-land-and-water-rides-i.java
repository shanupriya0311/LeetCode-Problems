class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n=landStartTime.length;
        int m=waterStartTime.length;
        int minlen=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int v=landStartTime[i]+landDuration[i];
            int s=v;
            for(int j=0;j<m;j++){
                if(v>=waterStartTime[j]){
                    v+=waterDuration[j];
                }
                else if (v< waterStartTime[j]){
                    v=waterStartTime[j]+waterDuration[j];
                }
                minlen=Math.min(minlen,v);
                v=s;
            }
        }
        //water
        for(int i=0;i<m;i++){
            int s=waterStartTime[i]+waterDuration[i];
            int v=s;
            for(int j=0;j<n;j++){
                if(v>=landStartTime[j]){
                    v+=landDuration[j];
                }
                else if (v <landStartTime[j]){
                    v=landStartTime[j]+landDuration[j];
                }
                minlen=Math.min(minlen,v);
                v=s;
            }
        }
        return  minlen;
    }
}