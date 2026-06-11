class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> q =new ArrayDeque<>();
        int l=0;
        int r=0;
        int[] ans =new int[n-k+1];
        int j=0;

        while(r<n){

            while(r - l + 1 > k ) l++;

         

            while(!q.isEmpty() && nums[q.peekLast()] <= nums[r]){
                q.pollLast();
            }

            while(!q.isEmpty() && q.peekFirst() < l ){
                 q.pollFirst();
            }


            
         
            

            q.addLast(r);

            if( r-l+1 == k ){
               ans[j++]=nums[q.peekFirst()];
            }

            r++;
        }

        return ans;
    }
}
