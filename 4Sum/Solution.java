class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        int n=nums.size();
        long long sum=0;
        sort(nums.begin(),nums.end());
        set<vector<int>>result;
        vector<vector<int>>r1;
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                int k=j+1;
                int l=n-1;
                while(k<l){
                  sum=(long long)nums[i]+nums[j]+nums[k]+nums[l];
                  if(target>sum){
                    k++;
                  }
                  else if(target<sum){
                    l--;
                  }
                  else{
                    result.insert({nums[i],nums[j],nums[k],nums[l]});
                    k++;
                    l--;
                  }
                }
            }
        }
        for(auto& i:result){
            r1.push_back(i);
        }
        return r1;
    }
};
