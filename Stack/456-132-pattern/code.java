//https://leetcode.com/problems/132-pattern/
class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st =new Stack<>();
        int n=nums.length;

        int num=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(nums[i]<num){
                return true;
            }

            while(!st.isEmpty() && st.peek()<nums[i]){
                num=st.pop();
            }

            st.push(nums[i]);
        }

        return false;
    }
}
