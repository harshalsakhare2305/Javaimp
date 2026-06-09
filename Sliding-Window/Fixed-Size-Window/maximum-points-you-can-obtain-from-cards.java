//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
    
        int[] prefix =new int[n+1];
        prefix[0]=0;
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+cardPoints[i-1];
        }

        int[] suffix =new int[n+1];
        suffix[n]=0;
        for(int i=n-1;i>=0;i--){
            suffix[i]=suffix[i+1]+cardPoints[i];
        }
        int maxi=0;
        for(int i=0;i<=k;i++){
            
            maxi=Math.max(maxi,prefix[i]+(n-k+i<n?suffix[n-k+i]:0));
        }

        return maxi;
    }
}
