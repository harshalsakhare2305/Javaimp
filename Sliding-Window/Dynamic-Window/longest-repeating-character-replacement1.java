//https://leetcode.com/problems/longest-repeating-character-replacement/
class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();

        int[] freq =new int[26];
        int left=0;
        int right=0;

        int maxi=0;
        int maxFreq=0;

        while(left<=right && right<n){

            char ch=s.charAt(right);
            freq[ch-'A']++;
 
            maxFreq=Math.max(maxFreq , freq[ch-'A']);

            while( right - left + 1 - maxFreq > k){
                freq[s.charAt(left)-'A']--;
                left++;
            }

            maxi=Math.max(maxi, right - left + 1);
            right++;
        }

        return maxi;
    }
}
