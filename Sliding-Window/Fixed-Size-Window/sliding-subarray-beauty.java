//https://leetcode.com/problems/sliding-subarray-beauty/
class Solution {
    
    public int find(HashMap<Integer,Integer>mp,int x){
        int num=0;
        
        for(int i=-50;i<0;i++){
            if(mp.containsKey(i))num+=mp.get(i);

            if(num>=x)return i;
        }

        return 0;

    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n=nums.length;
        int l=0;
        int r=0;

        int j=0;
        int[] arr = new int[n-k+1];

        HashMap<Integer,Integer> mp =new HashMap<>();

        while(r<n && l<=r){
            // shring window condition

             
                 //Expand
            mp.put(nums[r],mp.getOrDefault(nums[r],0)+1);


            while(r-l+1>k){
               mp.put(nums[l],mp.get(nums[l])-1);
               if(mp.get(nums[l])==0)mp.remove(nums[l]);
               l++;
            }

         
        
            if(r-l+1==k){
                int res=find(mp,x);
                arr[j++]=res;
            }

            r++;
        } 

        return arr;
    }
}
