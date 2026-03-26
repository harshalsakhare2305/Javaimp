// So we have to segregate the VPS into two group also keeping in mind by minizing the deapth so the min deapth is (MaxDeapth/2)
//we need is a strategy to cut any stack in half while making sure that the resulting half-stacks are balanced VPS. There are many ways of doing that, but one of the easiest (and seemingly a very common) approach is the odd/even strategy:


//https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans =new int[seq.length()];
        int d=0;

        for(int i=0;i<seq.length();i++){
            boolean open=seq.charAt(i)=='(';
            if(open){
              ans[i]=d++%2;
            }else{
            ans[i]=--d%2;
            }

              
        }

        return ans;
    }
}
