class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
         Arrays.sort(nums1);
         Arrays.sort(nums2);
         Set<Integer>list=new HashSet<>();
         for(int i=0;i<nums1.length;i++){
            boolean result=binarysearch(nums2,nums1[i]);
            if(result)
            list.add(nums1[i]);
         }
         int s=list.size();
         int[] result=new int[s];
         int i=0;
         for(int h:list){
           result[i++]=h;
         }
         return result;
    }
    public boolean binarysearch(int[] nums2,int val){
         int low=0;
         int high=nums2.length-1;
         while(low<=high){
            int mid=(low+high)/2;
            if(nums2[mid]==val){
                return true;
            }
            else if(nums2[mid]>val){
                high=mid-1;
            }
            else if(nums2[mid]<val){
                low=mid+1;
            }
         }
         return false;
    }
}