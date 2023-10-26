class Solution {

    public  int[] nextGreaterElements1(int[] nums) {
        int n=nums.length;

        int[] res =new int[n];
        Stack<Integer> st =new Stack<>();
        
        res[n-1]=-1;
          st.push(nums[n-1]);
        for(int i=n-2;i>=0;i--){
           while(st.isEmpty()==false && st.peek()<=nums[i] ){
              st.pop();
              
           }

          if(st.size()==0){
            res[i]=-1;
          }else{
            res[i]=st.peek();
          }

          st.push(nums[i]);
        }
       return res;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
          int [] arr2 =nextGreaterElements1(nums2);//3 4 -1 -1

          HashMap<Integer,Integer> map =new HashMap<>();

          for(int i=0;i<nums2.length;i++){
              map.put(nums2[i],arr2[i]);
          }
          int [] ans =new int[nums1.length];

          for(int i=0;i<nums1.length;i++){
               ans[i]=map.get(nums1[i]);
          }

          return ans;
          
    }
}
