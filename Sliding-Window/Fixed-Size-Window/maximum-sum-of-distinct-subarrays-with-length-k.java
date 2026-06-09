//https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum=0;
        int l=0;
        int r=0;
        long INF=-(long)1e10;
        long maxi=INF;
        int n=nums.length;

        HashSet<Integer> st =new HashSet<>();

        while(r<n && l<=r){

            while(st.contains(nums[r]) || (r-l+1 > k)){
                st.remove(nums[l]);
                sum-=nums[l];
                l++;
            }

                st.add(nums[r]);
            sum+=nums[r];
           

            if(r-l+1==k){
                maxi=Math.max(maxi,sum);
            }
             r++;
             
        
        }

        return maxi==INF?0:maxi;
    }
}
