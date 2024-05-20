class Solution {

    //Hwre is One more Solution for this problem using upper and lower Bound

    public int lowerBound(int[] nums, int target) {
        int n =nums.length;
        int si =0;
        int ei=n-1;
      int ans=n;
        while(si<=ei){
            int mid =si+(ei-si)/2;
            if(nums[mid]>=target){
                ans=mid;
              ei=mid-1;
            } else{
                si=mid+1;
            } 
        }

        return ans;
    }

     public int UpperBound(int[] nums, int target) {
        int n =nums.length;
        int si =0;
        int ei=n-1;
      int ans=n;
        while(si<=ei){
            int mid =si+(ei-si)/2;
            if(nums[mid]>target){
                ans=mid;
              ei=mid-1;
            } else{
                si=mid+1;
            } 
        }

        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        // int first=-1;
        int n=nums.length;
        int lower=lowerBound(nums,target);
        int upper =UpperBound(nums,target);

        if(lower==n || nums[lower]!=target){
            return new int[]{-1,-1};
        }else{
            return new int[]{lower,upper-1};
        }



        // int low=0;
        // int high=n-1;

        // while(low<=high){
        //     int mid =low+(high-low)/2;

        //     if(nums[mid]==target){
        //         first=mid;
        //         high=mid-1;
        //     }else if(nums[mid]>target){
        //         high=mid-1;
        //     }else{
        //         low=mid+1;
        //     }
        // }

        // low=0;
        // high=n-1;
        // int last=-1;
        //    while(low<=high){
        //     int mid =low+(high-low)/2;

        //     if(nums[mid]==target){
        //         last=mid;
        //         low=mid+1;
        //     }else if(nums[mid]>target){
        //         high=mid-1;
        //     }else{
        //         low=mid+1;
        //     }
        // }

        // return new int[]{first,last};
    }
}
