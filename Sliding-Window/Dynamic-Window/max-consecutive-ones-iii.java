//https://leetcode.com/problems/max-consecutive-ones-iii/
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
     
     int left= 0;
     int right=0;

     int maxi=0;

     while(right<n){
        if(nums[right]==0)k--;

      while(k<0){
        if(nums[left]==0)k++;
        left++;
      }

      maxi=Math.max(maxi,right-left+1);
      right++;
     }

     return maxi;

    

    }
}
