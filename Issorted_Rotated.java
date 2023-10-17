class Solution {

    public int rotateIdx(int[] nums,int n){
        
     if(nums[0]>=nums[n-1]){


    for(int i=0;i<n-1;i++){
         if(nums[i]>nums[i+1]){
          return i+1; 
          }
    }

     }
    return -1;  //array is not rotated
    }

    public boolean isSorted(int[] nums,int j,int ei){
     if(  j == ei){
         return true;
     }
      for(int i=j;i<ei;i++){
         if(nums[i]>nums[i+1]){
          return false; 
          }
    }
    return true;
    }
    public boolean check(int[] nums) {
        int n=nums.length;
 if(isSorted(nums,0,n-1)==true){
      return true;
   }
   
   int idx =rotateIdx(nums,n);
      if(idx==-1){
       return false;
   }
  
        
 boolean ans = isSorted(nums,0,idx-1) && isSorted(nums,idx,n-1);

        return ans;
    }
}
