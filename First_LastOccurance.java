

//Brute fore :
//   first =-1  
//     Last =-1;
// for(int i=0;i<n;i++){
//   if(arr[i] ==target){
//   if(first==-1){
//     first =i;
//   }
//     last =i;
//   }
// }






// optimle Solution using Binarry Search

class Solution {

    public int lowerbound(int[] nums,int target){
        int n= nums.length;
        int ans=n;
        int si =0;
        int ei=n-1;
        while(si<=ei){

            int mid =si+(ei-si)/2;
            if(nums[mid]>=target){
                ans=mid;
                ei=mid-1;
            }else{
                si=mid+1;
            }
        }

        return ans;

    }

    public int upperbound(int[] nums,int target){
        int n= nums.length;
        int ans=n;
        int si =0;
        int ei=n-1;
        while(si<=ei){

            int mid =si+(ei-si)/2;
            if(nums[mid]>target){
                ans=mid;
                ei=mid-1;
            }else{
                si=mid+1;
            }
        }

        return ans;

    }
    public int[] searchRange(int[] nums, int target) {
       
int  n=nums.length;
int lb =lowerbound(nums,target);
if(lb==n || nums[lb]!=target ){
    int[] ans = new int[2];
    ans[0]=-1;
    ans[1]=-1;
    return ans;

}
 int[] ans1 =new int [2];
    ans1[0]=lb;
    ans1[1]=upperbound(nums,target)-1;

return ans1;
       

        

      


        
    }
}
