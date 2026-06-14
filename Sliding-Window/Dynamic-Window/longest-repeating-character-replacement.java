//https://leetcode.com/problems/longest-repeating-character-replacement/
class Solution {

    public int longestSubstringwithAllKey(char[] sarr,Character key,int k){
        int maxi=0;

        int n=sarr.length;
        int left=0;
        int right=0;

        while(left<=right && right<n){
            char c=sarr[right];
            if(c!=key){
                k--;
            }

            while(k<0){
               if(sarr[left]!=key)k++;
               left++; 
            }

            maxi=Math.max(maxi,right-left+1);
            right++;
        }

        return maxi;
    }

    public int characterReplacement(String s, int k) {
       HashMap<Character,Integer> mp =new HashMap<>();

       char[] sarr=s.toCharArray();

       for(char ch:sarr){
        mp.put(ch,mp.getOrDefault(ch,0)+1);
       }

       int maxi=0;

       for(Character key:mp.keySet()){
         maxi=Math.max(maxi,longestSubstringwithAllKey(sarr,key,k));
       }

       return maxi;



    }
}
