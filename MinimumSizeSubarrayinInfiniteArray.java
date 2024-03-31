class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        int length = nums.length * (target/sum);
        int ans = solve(nums,target%sum);
        return ans == -1? -1: ans+length;
    }



    private int solve(int[] nums, int target){
        if(target==0){
            return 0;
        }
        int j=0, sum=0, min = Integer.MAX_VALUE;
        for(int i=0;i<2*nums.length;i++){
            sum+=nums[i%nums.length];
            while(j<i && sum>target){
                sum-=nums[j++%nums.length];
            }
            if(sum==target){
                min = Math.min(min,i-j+1);
            }
        }
        return min==Integer.MAX_VALUE? -1: min;
    }
}
