//https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/
class Solution {
    public boolean canBeValid(String s, String locked) {
       
       int n=s.length();

       if(n%2==1)return false;
        
        Stack<Integer> open =new Stack<>();
        Stack<Integer> open_Close =new Stack<>();

        
        for(int i=0;i<n;i++){
            if(locked.charAt(i)=='0')open_Close.push(i);
            else{
                if(s.charAt(i)=='(')open.push(i);
                else{
                    if(!open.isEmpty()){
                        open.pop();
                    }else if(!open_Close.isEmpty()){
                        open_Close.pop();
                    }else{
                        return false;
                    }
                }
            }
        }

        while(!open.isEmpty() && !open_Close.isEmpty() && open.peek() < open_Close.peek()){
            open.pop();
            open_Close.pop();
        }

        if(!open.isEmpty())return false;

        return true;


    }
}
