//https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> st =new HashSet<>();

         int n=s.length();
         int left=0;
         int right=0;
         int maxi=0;
        
        while(left<=right && right<n){
            char ch = s.charAt(right);

            while(!st.isEmpty() && st.contains(ch)){
                st.remove(s.charAt(left));
                left++;
            }

            st.add(ch);
            maxi=Math.max(maxi,right-left+1);
            right++;
        }

        return maxi;
    }
}
